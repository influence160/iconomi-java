package net.iconomi.api.client;

import net.iconomi.api.client.model.Balance;
import net.iconomi.api.client.model.Strategy;
import net.iconomi.api.client.model.Chart;
import net.iconomi.api.client.model.Ticker;
import net.iconomi.api.client.model.Structure;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface IconomiService {

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
