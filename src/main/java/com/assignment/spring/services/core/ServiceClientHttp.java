package com.assignment.spring.services.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class ServiceClientHttp {
	
	private final Logger logger = LoggerFactory.getLogger(ServiceClientHttp.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	public ServiceClientHttp() {
		
	}
	
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
