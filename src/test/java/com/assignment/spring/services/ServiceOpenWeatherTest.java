package com.assignment.spring.services;

import com.assignment.spring.services.external.ServiceOpenWeather;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        "openweather.appid=Gf8JgdtvHOKpb0dqtA4j3Y6XtEj8/wnzGVIjDcT7sGnEX3Olq26MYUKdcmRYWYpz",
        "openweather.api.baseurl=http://api.openweathermap.org/data/2.5"
})
public class ServiceOpenWeatherTest {

    @Autowired
    private ServiceOpenWeather serviceOpenWeather;

}
