
package com.assignment.spring.models.external.openweatherapi;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Wind {

    @JsonProperty("speed")
    private Double speed;
    
    @JsonProperty("deg")
    private Integer degree;


    @JsonProperty("speed")
    public Double getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @JsonProperty("deg")
    public Integer getDeg() {
        return degree;
    }

    @JsonProperty("deg")
    public void setDeg(Integer deg) {
        this.degree = deg;
    }
}
