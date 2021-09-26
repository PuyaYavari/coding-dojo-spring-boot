package com.assignment.spring.exceptions;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ExceptionOpenweatherTest {

    @Test
    @Parameters(method = "integerTestParams")
    public void getCodeTest(int code) {
        ExceptionOpenweather ex = new ExceptionOpenweather("",code);
        assertEquals(code,ex.getCode());
    }

    private Object[] integerTestParams() {
        return new Object[] {
                new Object[] { 1 },
                new Object[] { 2 },
                new Object[] { 0 },
                new Object[] { -1 },
                new Object[] { Integer.MAX_VALUE },
                new Object[] { Integer.MIN_VALUE }
        };
    }
}
