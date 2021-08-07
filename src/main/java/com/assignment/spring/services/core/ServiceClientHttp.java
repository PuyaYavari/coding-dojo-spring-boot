package com.assignment.spring.services.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceClientHttp {
	
	@Autowired
	RestTemplate restTemplate;
	
	public <T> ResponseEntity<T> execute(
			String baseURL,
			Class<T> returnType
	) {
		return restTemplate.getForEntity(baseURL, returnType);
	}
}
