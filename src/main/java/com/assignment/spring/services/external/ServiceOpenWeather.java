package com.assignment.spring.services.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.assignment.spring.models.external.openweatherapi.WeatherResponse;
import com.assignment.spring.services.core.ServiceClientHttp;

@Service
public class ServiceOpenWeather extends ServiceClientHttp {

	@Value("${openweather.appid}")
    private String openweatherAppId;
	
	@Value("${openweather.api.baseurl}")
    private String openweatherBaseUrl;
	
	public WeatherResponse getWeather(String city) {
		String temp = "http://api.openweathermap.org/data/2.5/weather?q={city}&APPID={appid}";
		String url = temp.replace("{city}", city).replace("{appid}", openweatherAppId);
		return this.execute(url,WeatherResponse.class).getBody();
	}
	
}
