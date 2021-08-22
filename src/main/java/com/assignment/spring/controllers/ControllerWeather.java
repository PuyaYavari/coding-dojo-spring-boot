package com.assignment.spring.controllers;

import com.assignment.spring.entities.EntityWeather;
import com.assignment.spring.services.ServiceWeather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerWeather {
	
	@Autowired
	private ServiceWeather weatherService;

    @GetMapping("/weather")
    public EntityWeather weather(
    		@RequestParam(required = true) String city
    ) {
		return weatherService.getWeatherByCity(city); 
    }
}
