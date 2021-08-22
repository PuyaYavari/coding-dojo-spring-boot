package com.assignment.spring.services.external;

import com.assignment.spring.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.assignment.spring.exceptions.ExceptionOpenweather;
import com.assignment.spring.models.external.openweatherapi.WeatherResponse;
import com.assignment.spring.services.ServiceWeather;
import com.assignment.spring.services.core.ServiceClientHttp;

import javax.crypto.SecretKeyFactory;
import java.security.NoSuchAlgorithmException;

@Service
public class ServiceOpenWeather extends ServiceClientHttp {
	
	private final Logger logger = LoggerFactory.getLogger(ServiceWeather.class);

    private final String openweatherAppId;

	private final String openweatherBaseUrl;

	@Autowired
	public ServiceOpenWeather(
			@Value("${openweather.api.baseurl}") String openweatherBaseUrl,
			@Value("${openweather.appid}") String openweatherAppId
	) {
		this.openweatherBaseUrl = openweatherBaseUrl;
		String appId = "";
		try {
			String appSecret = SecurityUtils.getAppSecret();
			appId = SecurityUtils.decryptAES(
					openweatherAppId,
					SecurityUtils.getKeySpec(appSecret));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.openweatherAppId = appId;
	}
	
	public WeatherResponse getWeatherByCity(String city){
		return this.getWeatherByCity(openweatherAppId, openweatherBaseUrl, city);
	}
	
	public WeatherResponse getWeatherByCity(
			String openweatherAppId,
			String openweatherBaseUrl,
			String city
	) {
		UriComponentsBuilder builder = 
				UriComponentsBuilder.fromHttpUrl(openweatherBaseUrl)
					.pathSegment("weather")
					.queryParam("q", city)
					.queryParam("APPID", openweatherAppId);
		WeatherResponse weatherResponse = this.get(
				builder,
				WeatherResponse.class);
		if(weatherResponse != null) {
			logger.info(String.format("Weather data for %s retreived from OpenWeather API.", city));
			return weatherResponse;			
		} else {
			logger.error(String.format("No weather data found for %s.", city));
			throw new ExceptionOpenweather("No data found for given city!");			
		}
	}
	
}
