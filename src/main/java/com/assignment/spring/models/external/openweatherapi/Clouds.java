
package com.assignment.spring.models.external.openweatherapi;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Clouds {

    @JsonProperty("all")
    private Integer all;
    

    @JsonProperty("all")
    public Integer getAll() {
        return all;
    }

    @JsonProperty("all")
    public void setAll(Integer all) {
        this.all = all;
    }
}
