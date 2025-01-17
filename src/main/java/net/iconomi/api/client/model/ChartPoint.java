package net.iconomi.api.client.model;

/**
 * Copyright (c) 2019 ICONOMI Inc. All rights reserved.
 *
 * @author Tomaž Cerar
 */
public class ChartPoint {

    private Long x;
    private String y;

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "ChartPoint{" +
                "x='" + x + '\'' +
                ", y=" + y +
                '}';
    }
}
