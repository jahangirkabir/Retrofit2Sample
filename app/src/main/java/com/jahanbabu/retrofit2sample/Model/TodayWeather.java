package com.jahanbabu.retrofit2sample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by JK on 12/7/16.
 */
public class TodayWeather {

    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("temperature")
    @Expose
    private String temperature;

    /**
     *
     * @return
     * The pressure
     */
    public String getPressure() {
        return pressure;
    }

    /**
     *
     * @param pressure
     * The pressure
     */
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    /**
     *
     * @return
     * The temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     *
     * @param temperature
     * The temperature
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
