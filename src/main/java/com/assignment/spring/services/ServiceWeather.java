package com.assignment.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.spring.entities.WeatherEntity;
import com.assignment.spring.models.external.openweatherapi.WeatherResponse;
import com.assignment.spring.repositories.WeatherRepository;
import com.assignment.spring.services.external.ServiceOpenWeather;

@Service
public class ServiceWeather {

    @Autowired
    private WeatherRepository weatherRepository;
    
    @Autowired
    private ServiceOpenWeather openweatherService;
	
	public WeatherEntity getWeather(String city) {
        return mapper(openweatherService.getWeather(city));
	}
	
	private WeatherEntity mapper(WeatherResponse response) {
        WeatherEntity entity = new WeatherEntity();
        entity.setCity(response.getName());
        entity.setCountry(response.getSys().getCountry());
        entity.setTemperature(response.getMain().getTemp());

        return weatherRepository.save(entity);
    }
}
