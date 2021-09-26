package com.assignment.spring.models;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ModelErrorTest {
    @Test
    @Parameters(method = "errorTestParams")
    public void constructorTest(int code, String message) {
        ModelError error = new ModelError(code, message);
        assertEquals(code, error.code);
        assertEquals(message, error.message);
    }

    private Object[] errorTestParams() {
        return new Object[] {
                new Object[] { 1, "a" },
                new Object[] { 0, "" },
                new Object[] { -1, null }
        };
    }
}
