package com.assignment.spring.models.external.openweatherapi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class WeatherTest {
    private final Weather weather;

    public WeatherTest() {
        weather = new Weather();
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetIdTest(Integer input) {
        weather.setId(input);
        assertEquals(input, weather.getId());
    }

    @Test
    @Parameters(method = "stringTestParams")
    public void getSetMainTest(String input) {
        weather.setMain(input);
        assertEquals(input, weather.getMain());
    }

    @Test
    @Parameters(method = "stringTestParams")
    public void getSetDescriptionTest(String input) {
        weather.setDescription(input);
        assertEquals(input, weather.getDescription());
    }

    @Test
    @Parameters(method = "stringTestParams")
    public void getSetIconTest(String input) {
        weather.setIcon(input);
        assertEquals(input, weather.getIcon());
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

    private Object[] stringTestParams() {
        return new Object[] {
                new Object[] { "a" },
                new Object[] { "1" },
                new Object[] { "NL" },
                new Object[] { "" },
                new Object[] { null }
        };
    }
}
