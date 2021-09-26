package com.assignment.spring.mappers;

import com.assignment.spring.entities.EntityWeather;
import com.assignment.spring.models.external.openweatherapi.Main;
import com.assignment.spring.models.external.openweatherapi.Sys;
import com.assignment.spring.models.external.openweatherapi.WeatherResponse;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnitParamsRunner.class)
public class MapperEntityWeatherImplTest {
    private final MapperEntityWeatherImpl weatherMapper;

    public MapperEntityWeatherImplTest() {
        this.weatherMapper = new MapperEntityWeatherImpl();
    }

    @Test
    @Parameters(method = "weatherTestParams")
    public void mapFromWeatherResponseTest(String city, String country, Double temperature) {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setName(city);
        Sys sys = new Sys();
        sys.setCountry(country);
        Main main = new Main();
        main.setTemp(temperature);
        weatherResponse.setSys(sys);
        weatherResponse.setMain(main);
        EntityWeather actual = weatherMapper.mapFromWeatherResponse(weatherResponse);
        assertEquals(city, actual.getCity());
        assertEquals(country, actual.getCountry());
        assertEquals(temperature, actual.getTemperature(), 0.01);
    }

    @Test
    public void mapFromWeatherResponseTest_NullSys() {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setName("city");
        Main main = new Main();
        main.setTemp(1.0);
        weatherResponse.setSys(null);
        weatherResponse.setMain(main);
        EntityWeather actual = weatherMapper.mapFromWeatherResponse(weatherResponse);
        assertNull(actual.getCountry());
    }

    @Test
    public void mapFromWeatherResponseTest_NullMain() {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setName("city");
        Sys sys = new Sys();
        sys.setCountry("country");
        weatherResponse.setSys(sys);
        weatherResponse.setMain(null);
        EntityWeather actual = weatherMapper.mapFromWeatherResponse(weatherResponse);
        assertNull(actual.getTemperature());
    }

    private Object[] weatherTestParams() {
        return new Object[] {
                new Object[] { "a", "b", 1.0 },
                new Object[] { "city", "country", Double.MAX_VALUE },
                new Object[] { "city", "country", Double.MIN_VALUE },
                new Object[] { "", "", 0.0 },
                new Object[] { null, null, Double.NaN }
        };
    }
}
