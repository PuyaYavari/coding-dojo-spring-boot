package com.assignment.spring.services.external;

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
public class ServiceOpenWeather extends ServiceClientHttp  {

	private final Logger logger = LoggerFactory.getLogger(ServiceWeather.class);

	private final String openweatherBaseUrl;

    private final String openweatherAppId;

	@Autowired
	public ServiceOpenWeather(
			@Value("${openweather.api.baseurl}") String openweatherBaseUrl,
			@Value("${openweather.appid}") String openweatherAppId
	) {
		super();
		this.openweatherBaseUrl = openweatherBaseUrl;
		this.openweatherAppId = openweatherAppId;
	}

	/**
	 * This function requests weather information of the given city from the OpenWeather api.
	 * @param city The name of the city to get weather information of
	 * @return Response returned by the OpenWeather api
	 */
	public WeatherResponse getWeatherByCity(String city){
		return this.getWeatherByCity(openweatherAppId, openweatherBaseUrl, city);
	}

	/**
	 * This function requests weather information of the given city from the OpenWeather api.
	 * @param openweatherAppId OpenWeather application ID provided by OpenWeather
	 * @param openweatherBaseUrl OpenWeather api base url
	 * @param city The name of the city to get weather information of
	 * @return Response returned by the OpenWeather api
	 */
	public WeatherResponse getWeatherByCity(
			String openweatherAppId,
			String openweatherBaseUrl,
			String city
	) {
		logger.debug(String.format("Retrieving Weather data for %s from OpenWeather API.", city));
		UriComponentsBuilder builder = 
				UriComponentsBuilder.fromHttpUrl(openweatherBaseUrl)
					.pathSegment("weather")
					.queryParam("q", city)
					.queryParam("APPID", openweatherAppId);
		WeatherResponse weatherResponse = this.get(
				builder,
				WeatherResponse.class);
		if(weatherResponse != null) {
			logger.info(String.format("Weather data for %s retrieved from OpenWeather API.", city));
			return weatherResponse;			
		} else {
			logger.error(String.format("No weather data found for %s.", city));
			throw new ExceptionOpenweather("No data found for given city!",2001);
		}
	}
	
}
