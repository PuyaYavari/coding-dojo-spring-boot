package com.assignment.spring.controllers;

import com.assignment.spring.entities.EntityWeather;
import com.assignment.spring.services.ServiceWeather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerWeather {
    private final Logger logger = LoggerFactory.getLogger(ControllerWeather.class);
	
	@Autowired
	private ServiceWeather weatherService;

    /**
     * This endpoint gets given cities weather data from OpenWeather
     * then logs and return temperature data
     * @param city Name of the city to get the weather information
     * @return Temperature information of the given city
     */
    @GetMapping("/weather")
    public EntityWeather weather(
    		@RequestParam(required = true) String city
    ) {
        logger.info("Request received. Endpoint: weather City: " + city);
		return weatherService.getWeatherByCity(city); 
    }
}
