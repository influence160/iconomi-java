package net.iconomi.api.client.model;

import java.math.BigDecimal;

/**
 * Copyright (c) 2019 ICONOMI Inc. All rights reserved.
 *
 * @author Tomaž Cerar
 */
public class Ticker {

    private String ticker;
    private String currency;
    private BigDecimal price;
    private BigDecimal change24h;
    private BigDecimal change7d;
    private BigDecimal change1m;
    private BigDecimal change3m;
    private BigDecimal change6m;
    private BigDecimal change12m;
    private BigDecimal changeAll;
    private BigDecimal aum;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getChange24h() {
        return change24h;
    }

    public void setChange24h(BigDecimal change24h) {
        this.change24h = change24h;
    }

    public BigDecimal getChange7d() {
        return change7d;
    }

    public void setChange7d(BigDecimal change7d) {
        this.change7d = change7d;
    }

    public BigDecimal getChange1m() {
        return change1m;
    }

    public void setChange1m(BigDecimal change1m) {
        this.change1m = change1m;
    }

    public BigDecimal getChange3m() {
        return change3m;
    }

    public void setChange3m(BigDecimal change3m) {
        this.change3m = change3m;
    }

    public BigDecimal getChange6m() {
        return change6m;
    }

    public void setChange6m(BigDecimal change6m) {
        this.change6m = change6m;
    }

    public BigDecimal getChange12m() {
        return change12m;
    }

    public void setChange12m(BigDecimal change12m) {
        this.change12m = change12m;
    }

    public BigDecimal getChangeAll() {
        return changeAll;
    }

    public void setChangeAll(BigDecimal changeAll) {
        this.changeAll = changeAll;
    }

    public BigDecimal getAum() {
        return aum;
    }

    public void setAum(BigDecimal aum) {
        this.aum = aum;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "ticker='" + ticker + '\'' +
                ", currency=" + currency +
                ", price='" + price + '\'' +
                ", change24h='" + change24h + '\'' +
                ", change7d='" + change7d + '\'' +
                ", change1m='" + change1m + '\'' +
                ", change3m='" + change3m + '\'' +
                ", change6m='" + change6m + '\'' +
                ", change12m='" + change12m + '\'' +
                ", changeAll='" + changeAll + '\'' +
                ", aum='" + aum + '\'' +
                '}';
    }
}
