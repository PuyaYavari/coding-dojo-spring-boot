package com.assignment.spring.models.external.openweatherapi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class WindTest {
    private final Wind wind;

    public WindTest() {
        wind = new Wind();
    }

    @Test
    @Parameters(method = "doubleTestParams")
    public void getSetSpeedTest(Double input) {
        wind.setSpeed(input);
        assertEquals(input, wind.getSpeed(), 0.01);
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetDegreeTest(Integer input) {
        wind.setDeg(input);
        assertEquals(input, wind.getDeg());
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
}
