package com.which.locator.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.which.locator.model.DirectionsMoved;

/**
 * Directoinservice retrives directions from forensic directions API
 */
@Component
public class DirectionService {
	
	/**
	 * Gets the directions from forensic directions API
	 *
	 * @param email to pass as a input
	 * 
	 * @return directions
	 */

	public DirectionsMoved getDirectionsmoved(String email) {

		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());

		String directionsApiUrl = "http://which-technical-exercise.herokuapp.com/api/" + email + "/directions";

		ResponseEntity<DirectionsMoved> response = restTemplate.getForEntity(directionsApiUrl, DirectionsMoved.class);

		DirectionsMoved directionsMap = response.getBody();

		return directionsMap;
	}

	/**
	 * set timeout configurations for API. This can be changes based on API spec
	 *
	 * @param
	 * 
	 * @return HTTP factory with connection timeouts
	 */
	private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();

		clientHttpRequestFactory.setConnectTimeout(6000);

		clientHttpRequestFactory.setReadTimeout(6000);
		return clientHttpRequestFactory;
	}
}
