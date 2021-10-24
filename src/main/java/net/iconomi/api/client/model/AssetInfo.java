package net.iconomi.api.client.model;

public class AssetInfo {

    private String ticker;
    private String name;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AssetInfo{" +
                "ticker='" + ticker + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
