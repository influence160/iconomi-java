package net.iconomi.api.client.model;

import java.util.List;

/**
 * Copyright (c) 2019 ICONOMI Inc. All rights reserved.
 *
 * @author Tomaž Cerar
 */
public class Chart {

    public static enum Granulation {
        TWO_MINUTE,
        FIVE_MINUTE,
        FIFTEEN_MINUTE,
        HOURLY,
        THREE_HOURLY,
        EIGHT_HOURLY,
        DAILY
    }

    private String ticker;
    private Currency currency;
    private long from;
    private long to;
    private Granulation granulation;
    private List<ChartPoint> values;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public Granulation getGranulation() {
        return granulation;
    }

    public void setGranulation(Granulation granulation) {
        this.granulation = granulation;
    }

    public List<ChartPoint> getValues() {
        return values;
    }

    public void setValues(List<ChartPoint> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "ticker='" + ticker + '\'' +
                ", currency=" + currency +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", granulation='" + granulation + '\'' +
                ", values='" + values + '\'' +
                '}';
    }
}
