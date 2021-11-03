package com.which.locator.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.which.locator.model.LocationValidation;

@Component
public class LocationValidationService {

	public LocationValidation validateResult(int x, int y, String email) {
	
		
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		
		String locationApiurl = "http://which-technical-exercise.herokuapp.com/api/"+ email +"/location/"
				+ x + "/" + y;

		ResponseEntity<LocationValidation> response = restTemplate.getForEntity(locationApiurl, LocationValidation.class);

		LocationValidation locationValidation = response.getBody();

		return locationValidation ;
		
	}
	
	

	private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();

		clientHttpRequestFactory.setConnectTimeout(6000);

		clientHttpRequestFactory.setReadTimeout(6000);
		return clientHttpRequestFactory;
	}

}
