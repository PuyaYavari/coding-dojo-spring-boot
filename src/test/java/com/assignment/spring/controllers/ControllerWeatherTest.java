package com.assignment.spring.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.assignment.spring.entities.EntityWeather;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.spring.exceptions.ExceptionOpenweather;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        "openweather.appid=WeskRMJM1YGDE6a6XTRYMq3bthUGmhUrE5kcnDS8dg4zqC7MnFNgnh0G+8LyLM55",
        "openweather.api.baseurl=http://api.openweathermap.org/data/2.5"
})
public class ControllerWeatherTest {
	
	@Autowired
    private ControllerWeather weatherController;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	
	@Test
	public void existingCityResponse() {
		EntityWeather actual = weatherController.weather(
        		"istanbul"
        );
        assertEquals("TR", actual.getCountry());
        assertEquals("Istanbul", actual.getCity());
        assertNotNull(actual.getTemperature());
	}
	
	@Test(expected = ExceptionOpenweather.class)
	public void notExistingCityResponse() {
        weatherController.weather(
        		"istanbululu"
        );
	}
}
