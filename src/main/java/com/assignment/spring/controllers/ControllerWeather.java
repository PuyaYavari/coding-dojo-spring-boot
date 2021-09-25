package com.assignment.spring.controllers;

import com.assignment.spring.entities.EntityWeather;
import com.assignment.spring.services.ServiceWeather;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "Weather Api documentation")
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
    @ApiOperation(value = "Get city weather information.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully inserted weather information"),
            @ApiResponse(code = 400, message = "Missing or invalid query param"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public EntityWeather weather(
            @ApiParam(value = "The name of the city to get the weather information.", required = true, defaultValue = "")
    		@RequestParam(required = true) String city
    ) {
        logger.info("Request received. Endpoint: weather City: " + city);
		return weatherService.getWeatherByCity(city); 
    }
}
