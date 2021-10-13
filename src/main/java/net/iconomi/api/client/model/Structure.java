package net.iconomi.api.client.model;

import java.util.List;

/**
 * Copyright (c) 2019 ICONOMI Inc. All rights reserved.
 *
 * @author Tomaž Cerar
 */
public class Structure {

    private String ticker;
    private List<StructureElement> values;
    private Integer numberOfAssets;
    private Integer lastRebalanced;
    private Integer monthlyRebalancedCount;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public List<StructureElement> getValues() {
        return values;
    }

    public void setValues(List<StructureElement> values) {
        this.values = values;
    }

    public Integer getNumberOfAssets() {
        return numberOfAssets;
    }

    public void setNumberOfAssets(Integer numberOfAssets) {
        this.numberOfAssets = numberOfAssets;
    }

    public Integer getLastRebalanced() {
        return lastRebalanced;
    }

    public void setLastRebalanced(Integer lastRebalanced) {
        this.lastRebalanced = lastRebalanced;
    }

    public Integer getMonthlyRebalancedCount() {
        return monthlyRebalancedCount;
    }

    public void setMonthlyRebalancedCount(Integer monthlyRebalancedCount) {
        this.monthlyRebalancedCount = monthlyRebalancedCount;
    }

    @Override
    public String toString() {
        return "Structure{" +
                "ticker='" + ticker + '\'' +
                ", values=" + values +
                ", numberOfAssets='" + numberOfAssets + '\'' +
                ", lastRebalanced='" + lastRebalanced + '\'' +
                ", monthlyRebalancedCount='" + monthlyRebalancedCount + '\'' +
                '}';
    }
}
