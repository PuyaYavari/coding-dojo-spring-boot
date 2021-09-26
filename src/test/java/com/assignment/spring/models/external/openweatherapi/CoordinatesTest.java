package com.assignment.spring.models.external.openweatherapi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CoordinatesTest {
    private final Coordinates coordinates;

    public CoordinatesTest() {
        coordinates = new Coordinates();
    }

    @Test
    @Parameters(method = "doubleTestParams")
    public void getSetLonTest(Double input) {
        coordinates.setLonongitude(input);
        assertEquals(input, coordinates.getLongitude(), 0.01);
    }

    @Test
    @Parameters(method = "doubleTestParams")
    public void getSetLatTest(Double input) {
        coordinates.setLatitude(input);
        assertEquals(input, coordinates.getLatitude(), 0.01);
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
