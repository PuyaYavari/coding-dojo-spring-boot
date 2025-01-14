package com.assignment.spring;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.spring.controllers.ControllerWeather;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
		"openweather.appid=appid",
		"openweather.api.baseurl=http://localhost:8081/data/2.5"
})
public class ApplicationTests extends DatabaseMockedTest {

	@Autowired
    private ControllerWeather weatherController;
	
	@Test
	public void contextLoads() {
		assertNotNull(weatherController);
	}

}
