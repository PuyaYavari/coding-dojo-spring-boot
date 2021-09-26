package com.assignment.spring.models.external.openweatherapi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class WeatherResponseTest {
    private final WeatherResponse weatherResponse;

    public WeatherResponseTest() {
        weatherResponse = new WeatherResponse();
    }

    @Test
    @Parameters(method = "coordinatesTestParams")
    public void getSetCoordinatesTest(Double lon, Double lat) {
        Coordinates coordinates = new Coordinates();
        coordinates.setLonongitude(lon);
        coordinates.setLatitude(lat);
        weatherResponse.setCoord(coordinates);
        assertEquals(coordinates, weatherResponse.getCoord());
        assertEquals(coordinates.getLatitude(), weatherResponse.getCoord().getLatitude(), 0.01);
        assertEquals(coordinates.getLongitude(), weatherResponse.getCoord().getLongitude(), 0.01);
    }

    @Test
    @Parameters(method = "weatherTestParams")
    public void getSetWeatherTest(Integer id, String main, String description, String icon) {
        Weather weather = new Weather();
        weather.setId(id);
        weather.setMain(main);
        weather.setIcon(icon);
        weather.setDescription(description);
        List<Weather> weathers = new ArrayList<>();
        weathers.add(weather);
        weatherResponse.setWeather(weathers);
        assertEquals(weathers.get(0).getId(), weatherResponse.getWeather().get(0).getId());
        assertEquals(weathers.get(0).getMain(), weatherResponse.getWeather().get(0).getMain());
        assertEquals(weathers.get(0).getDescription(), weatherResponse.getWeather().get(0).getDescription());
        assertEquals(weathers.get(0).getIcon(), weatherResponse.getWeather().get(0).getIcon());
    }

    @Test
    @Parameters(method = "stringTestParams")
    public void getSetBaseTest(String input) {
        weatherResponse.setBase(input);
        assertEquals(input, weatherResponse.getBase());
    }

    @Test
    @Parameters(method = "mainTestParams")
    public void getSetMainTest(Integer pressure, Integer humidity, Double temp, Double tempMin, Double tempMax) {
        Main main = new Main();
        main.setPressure(pressure);
        main.setHumidity(humidity);
        main.setTemp(temp);
        main.setTempMin(tempMin);
        main.setTempMax(tempMax);
        weatherResponse.setMain(main);
        assertEquals(main, weatherResponse.getMain());
        assertEquals(main.getPressure(), weatherResponse.getMain().getPressure());
        assertEquals(main.getHumidity(), weatherResponse.getMain().getHumidity());
        assertEquals(main.getTemp(), weatherResponse.getMain().getTemp(), 0.01);
        assertEquals(main.getTempMin(), weatherResponse.getMain().getTempMin(), 0.01);
        assertEquals(main.getTempMax(), weatherResponse.getMain().getTempMax(), 0.01);
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetVisibilityTest(Integer input) {
        weatherResponse.setVisibility(input);
        assertEquals(input, weatherResponse.getVisibility());
    }

    @Test
    @Parameters(method = "windTestParams")
    public void getSetWindTest(Double speed, Integer degree) {
        Wind wind = new Wind();
        wind.setSpeed(speed);
        wind.setDeg(degree);
        weatherResponse.setWind(wind);
        assertEquals(wind, weatherResponse.getWind());
        assertEquals(wind.getSpeed(), weatherResponse.getWind().getSpeed(), 0.01);
        assertEquals(wind.getDeg(), weatherResponse.getWind().getDeg());
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetWindTest(Integer all) {
        Clouds clouds = new Clouds();
        clouds.setAll(all);
        weatherResponse.setClouds(clouds);
        assertEquals(clouds, weatherResponse.getClouds());
        assertEquals(clouds.getAll(), weatherResponse.getClouds().getAll());
    }

    @Test
    @Parameters(method = "sysTestParams")
    public void getSetSysTest(Integer type, Integer id, Integer sunrise, Integer sunset, Double message, String country) {
        Sys sys = new Sys();
        sys.setType(type);
        sys.setId(id);
        sys.setSunrise(sunrise);
        sys.setSunset(sunset);
        sys.setMessage(message);
        sys.setCountry(country);
        weatherResponse.setSys(sys);
        assertEquals(sys, weatherResponse.getSys());
        assertEquals(sys.getType(), weatherResponse.getSys().getType());
        assertEquals(sys.getId(), weatherResponse.getSys().getId());
        assertEquals(sys.getSunrise(), weatherResponse.getSys().getSunrise());
        assertEquals(sys.getSunset(), weatherResponse.getSys().getSunset());
        assertEquals(sys.getMessage(), weatherResponse.getSys().getMessage());
        assertEquals(sys.getCountry(), weatherResponse.getSys().getCountry());
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetDtTest(Integer input) {
        weatherResponse.setDt(input);
        assertEquals(input, weatherResponse.getDt());
    }

    @Test
    @Parameters(method = "stringTestParams")
    public void getSetNameTest(String input) {
        weatherResponse.setName(input);
        assertEquals(input, weatherResponse.getName());
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetIdTest(Integer input) {
        weatherResponse.setId(input);
        assertEquals(input, weatherResponse.getId());
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetCodTest(Integer input) {
        weatherResponse.setCod(input);
        assertEquals(input, weatherResponse.getCod());
    }

    private Object[] stringTestParams() {
        return new Object[] {
                new Object[] { "a" },
                new Object[] { "1" },
                new Object[] { "NL" },
                new Object[] { "" },
                new Object[] { null }
        };
    }

    private Object[] integerTestParams() {
        return new Object[] {
                new Object[] { 1 },
                new Object[] { 0 },
                new Object[] { -1 },
                new Object[] { Integer.MAX_VALUE },
                new Object[] { Integer.MIN_VALUE },
                new Object[] { null }
        };
    }

    private Object[] coordinatesTestParams() {
        return new Object[] {
                new Object[] { 1.0, 1.0 },
                new Object[] { 1.0, 0.12 },
                new Object[] { -1.0, 0.1 },
                new Object[] { Double.MAX_VALUE, Double.MAX_VALUE },
                new Object[] { Double.MIN_VALUE, Double.MIN_VALUE },
                new Object[] { Double.NaN, Double.NaN }
        };
    }

    private Object[] mainTestParams() {
        return new Object[] {
                new Object[] { 1, 1, 1.0, 1.0, 1.0 },
                new Object[] { 1,1, 1.0, 0.12, 1.13 },
                new Object[] { 0, -1, -1.0, 0.1, 0.0 },
                new Object[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE },
                new Object[] { Integer.MIN_VALUE, Integer.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE },
                new Object[] { null, null, Double.NaN, Double.NaN, Double.NaN }
        };
    }

    private Object[] windTestParams() {
        return new Object[] {
                new Object[] { 1.0, 1 },
                new Object[] { 1.0, 0 },
                new Object[] { -1.0, 1 },
                new Object[] { Double.MAX_VALUE, Integer.MAX_VALUE },
                new Object[] { Double.MIN_VALUE, Integer.MIN_VALUE },
                new Object[] { Double.NaN, null }
        };
    }

    private Object[] weatherTestParams() {
        return new Object[] {
                new Object[] { 1, "a", "b", "c" },
                new Object[] { 0, "", "", "" },
                new Object[] { null, null, null, null },
        };
    }

    private Object[] sysTestParams() {
        return new Object[] {
                new Object[] { 1, 2, 3, 4, 5.0, "test" },
                new Object[] { 0, 0, 0, 0, 0.0, "" },
                new Object[] { null, null, null, null, Double.NaN, null },
                new Object[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Double.MAX_VALUE, "test" },
                new Object[] { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Double.MIN_VALUE, "test" },
        };
    }
}
