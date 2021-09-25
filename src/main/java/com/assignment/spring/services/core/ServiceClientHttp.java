package com.assignment.spring.services.core;

import com.assignment.spring.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


/**
 * Base HTTP client Service. All services that send any type of HTTP request
 * inherit this service and use this services methods
 */
@Service
public class ServiceClientHttp {
	
	private final Logger logger = LoggerFactory.getLogger(ServiceClientHttp.class);

	@Autowired
	protected SecurityUtils securityUtils;

	@Autowired
	protected RestTemplate restTemplate;
	
	public ServiceClientHttp() {
		
	}

	/**
	 * HTTP get request from a REST endpoint.
	 * @param uriBuilder Builder of the endpoint url.
	 * @param returnType Expected return type.
	 * @param <T> Expected return type.
	 * @return Response of the sent request which is an instance of the expected type.
	 * if the response is not successful returns null.
	 */
	public <T> T get(
			UriComponentsBuilder uriBuilder,
			Class<T> returnType
	) {
		try {
			ResponseEntity<T> response = restTemplate.getForEntity(uriBuilder.toUriString(), returnType);
			
			if(response.getStatusCode().is2xxSuccessful()) {
				return response.getBody();
			}
			
			return null;			
		} catch(RestClientException ex) {
			logger.error("Clinet exception",ex);
			return null;
		} catch(Exception ex) {
			logger.error("Unknown exception",ex);
			return null;
		}
		
	}
}
