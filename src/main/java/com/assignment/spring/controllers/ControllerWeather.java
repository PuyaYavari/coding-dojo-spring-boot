package com.assignment.spring.controllers;

import com.assignment.spring.entities.WeatherEntity;
import com.assignment.spring.services.ServiceWeather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerWeather extends ControllerBase {

	@Autowired
	private ServiceWeather weatherService;

    @GetMapping("/weather")
    public WeatherEntity weather(
    		@RequestParam(required = true) String city
    ) {
    	return weatherService.getWeather(city);
    }
}
