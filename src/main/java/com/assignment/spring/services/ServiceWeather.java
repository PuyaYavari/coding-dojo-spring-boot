package com.assignment.spring.services;

import com.assignment.spring.mappers.MapperEntityWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.spring.entities.EntityWeather;
import com.assignment.spring.models.external.openweatherapi.WeatherResponse;
import com.assignment.spring.repositories.WeatherRepository;
import com.assignment.spring.services.external.ServiceOpenWeather;

@Service
public class ServiceWeather {
	
	private final Logger logger = LoggerFactory.getLogger(ServiceWeather.class);

    @Autowired
    private WeatherRepository weatherRepository;
    
    @Autowired
    private ServiceOpenWeather openweatherService;

    @Autowired
    MapperEntityWeather entityWeatherMapper;

    /**
     * gets temperature data of the given city.
     * @param city The name of the city to get the temperature data of
     * @return Temperature data of the given city
     */
	public EntityWeather getWeatherByCity(String city){
		WeatherResponse response = openweatherService.getWeatherByCity(city);
		
		EntityWeather entity = entityWeatherMapper.mapFromWeatherResponse(response);
		
        weatherRepository.save(entity);
        logger.info(String.format("Weather data for %s saved to database.", city));
        
        return entity;
	}
}
