package com.assignment.spring.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SecurityUtilsTest {
    @Test
    public void encryptTest() throws Exception {
        String raw = "1887b5688db0b032867a66eadb8dcd14";
        String encrypted = SecurityUtils.encryptAES(raw, SecurityUtils.getKeySpec("ExampleSecretKey"));
    }
}
