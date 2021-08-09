package com.assignment.spring.services;

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
	
	public EntityWeather getWeatherByCity(String city){
		WeatherResponse response = openweatherService.getWeatherByCity(city);
		
		EntityWeather entity = mapToWeatherEntity(response);
		
        weatherRepository.save(entity);
        logger.info(String.format("Weather data for %s saved to database.", city));
        
        return entity;
	}
	
	protected EntityWeather mapToWeatherEntity(WeatherResponse response) {
        EntityWeather entity = new EntityWeather();
        entity.setCity(response.getName());
        entity.setCountry(response.getSys().getCountry());
        entity.setTemperature(response.getMain().getTemp());
        return entity;
    }
}
