package com.assignment.spring.models.external.openweatherapi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CloudsTest {
    private final Clouds clouds;

    public CloudsTest() {
        clouds = new Clouds();
    }

    @Test
    @Parameters(method = "integerTestParams")
    public void getSetAllTest(Integer input) {
        clouds.setAll(input);
        assertEquals(input, clouds.getAll());
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
