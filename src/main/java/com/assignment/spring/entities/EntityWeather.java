package com.assignment.spring.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "weather")
public class EntityWeather {

    @Id
    @Column(name="id")
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="city")
    @JsonProperty("city")
    private String city;

    @Column(name="country")
    @JsonProperty("country")
    private String country;

    @Column(name="temperature")
    @JsonProperty("temperature")
    private Double temperature;

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
