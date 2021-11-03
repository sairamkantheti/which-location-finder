package com.which.locator.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	
    private static final Logger logger = LogManager.getLogger(DirectionService.class);

	
	/**
	 * Gets the directions from forensic directions API
	 *
	 * @param email to pass as a input
	 * 
	 * @return directions
	 */

	public DirectionsMoved getDirectionsmoved(String email) {
		
		logger.info("##### Started fetching directions #########");

		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());

		String directionsApiUrl = "http://which-technical-exercise.herokuapp.com/api/" + email + "/directions";

		logger.info("Direction API url :"+ directionsApiUrl);
		
		ResponseEntity<DirectionsMoved> response = restTemplate.getForEntity(directionsApiUrl, DirectionsMoved.class);
		
		logger.info("##### received response from direction API #########");
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
