package net.iconomi.api.client.model;

/**
 *
 * @author Othmen TILIOUINE
 */
public class Asset {

    public static enum Status {
        ONLINE,
        OFFLINE,
        DELISTING,
        DELISTED,
        MAINTENANCE
    }

    private String ticker;
    private Boolean supported;
    private Boolean useInStrategy;
    private Boolean tradable;
    private Status status;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Boolean getSupported() {
        return supported;
    }

    public void setSupported(Boolean supported) {
        this.supported = supported;
    }

    public Boolean getUseInStrategy() {
        return useInStrategy;
    }

    public void setUseInStrategy(Boolean useInStrategy) {
        this.useInStrategy = useInStrategy;
    }

    public Boolean getTradable() {
        return tradable;
    }

    public void setTradable(Boolean tradable) {
        this.tradable = tradable;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AssetInfo{" +
                "ticker='" + ticker + '\'' +
                ", supported='" + supported + '\'' +
                ", useInStrategy='" + useInStrategy + '\'' +
                ", tradable='" + tradable + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
