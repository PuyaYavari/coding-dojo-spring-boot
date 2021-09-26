package com.assignment.spring.controllers;

import static org.junit.Assert.assertEquals;

import com.assignment.spring.DatabaseMockedTest;
import com.assignment.spring.entities.EntityWeather;
import com.assignment.spring.exceptions.ExceptionOpenweather;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockserver.integration.ClientAndServer;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
		"openweather.appid=appid",
		"openweather.api.baseurl=http://localhost:8081/data/2.5"
})
public class ControllerWeatherTest extends DatabaseMockedTest {
	private static ClientAndServer mockServer;

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
    private ControllerWeather weatherController;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@BeforeClass
	public static void startMockServer() {
		mockServer = startClientAndServer(8081);
	}

	@AfterClass
	public static void stopMockServer() {
		mockServer.stop();
	}

	@Before
	public void init() {
		mockServer.reset();
	}
	
	@Test
	public void existingCityResponse() throws IOException {
		mockServer
				.when(request().withMethod("GET").withPath("/data/2.5/weather")
						.withQueryStringParameter("q","istanbul"))
				.respond(response()
						.withStatusCode(200)
						.withBody(Files.readString(new File(ControllerWeatherTest.class.getClassLoader()
								.getResource("data/Istanbul.json").getFile()).toPath()))
						.withHeader(HttpHeaders.CONTENT_TYPE, MediaType.JSON_UTF_8.toString()));

		EntityWeather actual = weatherController.weather("istanbul");
        assertEquals("TR", actual.getCountry());
        assertEquals("Istanbul", actual.getCity());
        assertEquals(291.64, actual.getTemperature(), 0.01);
	}
	
	@Test(expected = ExceptionOpenweather.class)
	public void notExistingCityResponse() {
        weatherController.weather("unknownCity");
	}
}
