
package com.assignment.spring.models.external.openweatherapi;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Main {

    @JsonProperty("temp")
    private Double temp;
    
    @JsonProperty("pressure")
    private Integer pressure;
    
    @JsonProperty("humidity")
    private Integer humidity;
    
    @JsonProperty("temp_min")
    private Double tempMin;
    
    @JsonProperty("temp_max")
    private Double tempMax;
    
    
    @JsonProperty("temp")
    public Double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @JsonProperty("pressure")
    public Integer getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("temp_min")
    public Double getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    @JsonProperty("temp_max")
    public Double getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }
}
