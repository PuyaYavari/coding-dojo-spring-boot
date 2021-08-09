
package com.assignment.spring.models.external.openweatherapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {

    @JsonProperty("lon")
    private Double longitude;
    
    @JsonProperty("lat")
    private Double latitude;


    public Double getLongitude() {
        return longitude;
    }

    public void setLonongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
