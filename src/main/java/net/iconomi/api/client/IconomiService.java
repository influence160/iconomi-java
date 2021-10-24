package net.iconomi.api.client;

import net.iconomi.api.client.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface IconomiService {

    @GET("/v1/assets")
    Call<List<Asset>> listAssets();

    @GET("/v1/assets/{ticker}")
    Call<AssetInfo> getAssetDetails(@Path("ticker") String ticker);

    @GET("/v1/assets/{ticker}/price")
    Call<Ticker> getAssetPrice(@Path("ticker") String ticker);

    @GET("/v1/assets/{ticker}/price")
    Call<Ticker> getAssetPrice(@Path("ticker") String ticker, @Query("currency") Currency currency);

    @GET("/v1/assets/{ticker}/pricehistory")
    Call<Chart> getAssetPriceHistory(@Path("ticker") String ticker, @Query("from") Long from, @Query("to") Long to);

    @GET("/v1/assets/{ticker}/pricehistory")
    Call<Chart> getAssetPriceHistory(@Path("ticker") String ticker, @Query("currency") Currency currency, @Query("from") Long from, @Query("to") Long to, @Query("granulation") Chart.Granulation granulation);


    @GET("/v1/strategies")
    Call<List<Strategy>> listStrategies();

    @GET("/v1/strategies/{ticker}")
    Call<Strategy> getStrategy(@Path("ticker") String ticker);

    @GET("/v1/strategies/{ticker}/structure")
    Call<Structure> getStrategyStructure(@Path("ticker") String ticker);

    @GET("/v1/strategies/{ticker}/price")
    Call<Ticker> getStrategyPrice(@Path("ticker") String ticker);


    @GET("/v1/strategies/{ticker}/pricehistory")
    Call<Chart> getStrategyPriceHistory(@Path("ticker") String ticker, @Query("from") Long from, @Query("to") Long to);


    @GET("/v1/user/balance")
    Call<Balance> getUserBalance(@Query("currency") String currency);


}
