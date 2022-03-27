package net.iconomi.api.client;

import net.iconomi.api.client.model.*;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.List;

class IconomiRestApiImpl implements IconomiRestApi {
    private static final Logger log = LoggerFactory.getLogger(IconomiRestApiImpl.class);
    private final String apiKey;
    private final String apiSecret;
    private final Retrofit retrofit;
    private final IconomiService service;


    IconomiRestApiImpl(IconomiApiBuilder builder) {
        this.apiKey = builder.apiKey;
        this.apiSecret = builder.apiSecret;
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(60))
                .readTimeout(Duration.ofSeconds(60))
                .addInterceptor(this::addAuthHeaders)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(builder.baseApiUrl)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        service = retrofit.create(IconomiService.class);
    }

    @Override
    public List<Asset> getListAssets() throws IOException {
        return service.listAssets().execute().body();
    }

    @Override
    public AssetInfo getAssetDetails(String ticker) throws IOException {
        return service.getAssetDetails(ticker).execute().body();
    }

    @Override
    public Ticker getAssetPriceChanges(String ticker) throws IOException {
        return service.getAssetPrice(ticker).execute().body();
    }

    @Override
    public Ticker getAssetPriceChanges(String ticker, Currency currency) throws IOException {
        return service.getAssetPrice(ticker, currency).execute().body();
    }

    @Override
    public Chart getAssetPriceHistry(String ticker, long from, long to) throws IOException {
        return service.getAssetPriceHistory(ticker, from, to).execute().body();
    }

    @Override
    public Chart getAssetPriceHistry(String ticker, Currency currency, long from, long to, Chart.Granulation granulation) throws IOException {
        return service.getAssetPriceHistory(ticker, currency, from, to, granulation).execute().body();
    }

    @Override
    public List<Strategy> getStrategiesList() throws IOException {
        return service.listStrategies().execute().body();
    }

    @Override
    public Strategy getStrategy(String ticker) throws IOException {
        return service.getStrategy(ticker).execute().body();
    }

    @Override
    public Structure getStrategyStructure(String ticker) throws IOException {
        return service.getStrategyStructure(ticker).execute().body();
    }

    @Override
    public Chart getStrategyPriceHistry(String ticker, long from, long to) throws IOException {
        return service.getStrategyPriceHistory(ticker, from, to).execute().body();
    }

    @Override
    public BigDecimal getStrategyPrice(String ticker) throws IOException {
        Ticker daaPrice = service.getStrategyPrice(ticker).execute().body();
        if (daaPrice != null) {
            return daaPrice.getPrice();
        }
        return null;
    }

    @Override
    public Ticker getStrategyPriceChanges(String ticker) throws IOException {
        return service.getStrategyPrice(ticker).execute().body();
    }

    @Override
    public Balance getUserBalance() throws IOException {
        return service.getUserBalance("USD").execute().body();
    }

    private Response addAuthHeaders(Interceptor.Chain chain) throws IOException {
        if (apiKey == null) {
            return chain.proceed(chain.request());
        } else {
            Request original = chain.request();
            Request request = chain.request().newBuilder()
                                   .headers(getSignatureHeaders(original))
                                   .build();
            return chain.proceed(request);
        }

    }

    private Headers getSignatureHeaders(Request request) throws IOException {
        long timestamp = Instant.now().toEpochMilli();

        String body = "";
        if (request.body() != null) {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            body = buffer.readUtf8();
        }


        return Headers.of(
                "ICN-API-KEY", apiKey,
                "ICN-SIGN", generateServerDigest(request.method(), request.url().encodedPath(), timestamp, body),
                "ICN-TIMESTAMP", String.valueOf(timestamp));
    }

    private String generateServerDigest(String method, String uri, long timestamp, String body) {
        //return timestamp + request.getMethodValue() + uri + body;
        String checkDigestString = timestamp + method + uri + body;//  "GET+/v1/daa-list+123123123"; //timestamp in epoch milliseconds

        // hash server composited digest with algorithm and apikeys secret
        SecretKeySpec signingKey = new SecretKeySpec(apiSecret.getBytes(), "HmacSHA512");
        Mac mac;
        try {
            mac = Mac.getInstance(signingKey.getAlgorithm());
            mac.init(signingKey);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.warn("Could not ={}", signingKey.getAlgorithm());
            return null;
        }

        return Base64.getEncoder().encodeToString(mac.doFinal(checkDigestString.getBytes()));
    }
}
