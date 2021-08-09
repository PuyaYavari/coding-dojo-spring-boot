
package com.assignment.spring.models.external.openweatherapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


public class WeatherResponse {

    @JsonProperty("coord")
    private Coordinates coordinates;
    
    @JsonProperty("weather")
    private List<Weather> weather = null;
    
    @JsonProperty("base")
    private String base;
    
    @JsonProperty("main")
    private Main main;
    
    @JsonProperty("visibility")
    private Integer visibility;
    
    @JsonProperty("wind")
    private Wind wind;
    
    @JsonProperty("clouds")
    private Clouds clouds;
    
    @JsonProperty("dt")
    private Integer dt;
    
    @JsonProperty("sys")
    private Sys sys;
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("cod")
    private Integer cod;
    

    @JsonProperty("coord")
    public Coordinates getCoord() {
        return coordinates;
    }

    @JsonProperty("coord")
    public void setCoord(Coordinates coord) {
        this.coordinates = coord;
    }

    @JsonProperty("weather")
    public List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    @JsonProperty("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    @JsonProperty("sys")
    public Sys getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("cod")
    public Integer getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
