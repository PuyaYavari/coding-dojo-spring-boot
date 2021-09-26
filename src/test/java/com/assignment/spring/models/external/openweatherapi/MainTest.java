package com.assignment.spring.models.external.openweatherapi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MainTest {
    private final Main main;

    public MainTest() {
        this.main = new Main();
    }

    @Test
    @Parameters(method = "doubleTestParams")
    public void getSetTempTest(Double input) {
        main.setTemp(input);
        assertEquals(input, main.getTemp(), 0.01);
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetPressureTest(Integer input) {
        main.setPressure(input);
        assertEquals(input, main.getPressure());
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetHumidityTest(Integer input) {
        main.setHumidity(input);
        assertEquals(input, main.getHumidity());
    }

    @Test
    @Parameters(method = "doubleTestParams")
    public void getSetTempMinTest(Double input) {
        main.setTempMin(input);
        assertEquals(input, main.getTempMin(), 0.01);
    }

    @Test
    @Parameters(method = "doubleTestParams")
    public void getSetTempMaxTest(Double input) {
        main.setTempMax(input);
        assertEquals(input, main.getTempMax(), 0.01);
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
}
