package com.assignment.spring.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SecurityUtilsTest {

    private SecurityUtils securityUtils;

    @Before
    public void setUp() {
        securityUtils = new SecurityUtils("");
    }

    @Test
    @Parameters({
            "TestSecretKey123, 4bTZcKtYw3VwxZ6tkFl/RQ==, a",
            "TestSecretKey123, BXyzSgIjOYDKgxTZoS6UQw==, b",
            "TestSecretKey123, yGvVfW5THMqGH2U2Ur3K9g==, test"
    })
    public void decryptTest_SuccessCases(String key, String input, String expected) {
        Assert.assertEquals(expected, securityUtils.decryptAES(input, key));
    }

    @Test
    @Parameters({
            "TestSecretKey123, BadInput",
            "BadKey, BXyzSgIjOYDKgxTZoS6UQw==",
            "BadKey, BadInput"
    })
    public void decryptTest_FailCases(String key, String input) {
        Assert.assertNull(securityUtils.decryptAES(input, key));
    }

    @Test
    public void decryptTest_NullCases() {
        Assert.assertNull(securityUtils.decryptAES(null, null));
    }
}
