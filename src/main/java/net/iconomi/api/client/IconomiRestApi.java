package net.iconomi.api.client;

import net.iconomi.api.client.model.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface IconomiRestApi {

    /**
     * @return list of assets
     */
    List<Asset> getListAssets() throws IOException;

    /**
     * @param ticker Ticker of asset
     * @return {@link AssetInfo} with information about the Asset.
     */
    AssetInfo getAssetDetails(String ticker) throws IOException;

    /**
     * @param ticker name of asset
     * @return @link Ticker} with informations about price and price changes in USD
     */
    Ticker getAssetPriceChanges(String ticker) throws IOException;

    /**
     * @param ticker name of asset
     * @param currency Currency in which the values are returned
     * @return @link Ticker} with informations about price and price changes
     */
    Ticker getAssetPriceChanges(String ticker, Currency currency) throws IOException;

    /**
     * @param ticker name of asset
     * @return price history in USD
     */
    Chart getAssetPriceHistry(String ticker, long from, long to) throws IOException;

    /**
     * @param ticker name of asset
     * @return price history
     */
    Chart getAssetPriceHistry(String ticker, Currency currency, long from, long to, Chart.Granulation granulation) throws IOException;

    /**
     * @return List of daas
     */
    List<Strategy> getStrategiesList() throws IOException;

    /**
     * @param ticker name of digital portfolio
     * @return {@link Strategy} with information about digital portfolio
     */
    Strategy getStrategy(String ticker) throws IOException;

    /**
     * @param ticker name of daa
     * @return structure of Strategy
     */
    Structure getStrategyStructure(String ticker) throws IOException;

    /**
     * @param ticker name of daa
     * @return price
     */
    BigDecimal getStrategyPrice(String ticker) throws IOException;

    /**
     * @param ticker name of daa
     * @return @link Ticker} with informations about price and price changes
     */
    Ticker getStrategyPriceChanges(String ticker) throws IOException;

    /**
     * @param ticker name of daa
     * @return price history
     */
    Chart getStrategyPriceHistry(String ticker, long from, long to) throws IOException;

    /**
     * Returns balance for user that is logged in via api key
     *
     * @return {@link Balance} or null if user is not authorized
     */
    Balance getUserBalance() throws IOException;

}
