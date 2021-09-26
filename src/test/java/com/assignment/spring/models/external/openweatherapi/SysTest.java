package com.assignment.spring.models.external.openweatherapi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SysTest {
    private final Sys sys;

    public SysTest() {
        sys = new Sys();
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetTypeTest(Integer input) {
        sys.setType(input);
        assertEquals(input, sys.getType());
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetIdTest(Integer input) {
        sys.setId(input);
        assertEquals(input, sys.getId());
    }

    @Test
    @Parameters(method = "doubleTestParams")
    public void getSetMessageTest(Double input) {
        sys.setMessage(input);
        assertEquals(input, sys.getMessage(), 0.01);
    }

    @Test
    @Parameters(method = "stringTestParams")
    public void getSetCountryTest(String input) {
        sys.setCountry(input);
        assertEquals(input, sys.getCountry());
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetSunriseTest(Integer input) {
        sys.setSunrise(input);
        assertEquals(input, sys.getSunrise());
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetSunsetTest(Integer input) {
        sys.setSunset(input);
        assertEquals(input, sys.getSunset());
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

    private Object[] doubleTestParams() {
        return new Object[] {
                new Object[] { 1.0 },
                new Object[] { 1.0820374019238901238 },
                new Object[] { 0.0 },
                new Object[] { -1.0 },
                new Object[] { Double.MAX_VALUE },
                new Object[] { Double.MIN_VALUE },
                new Object[] { Double.NaN }
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
