package com.which.locator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.which.locator.data.Locationinfo;
import com.which.locator.finder.CoordinatesFinderAndValidator;
import com.which.locator.service.DirectionService;

/**
 * Controller for the location finder.
 * get directions received from forensic are used to calculate the exact
 * direction of mysterious woman who is responsible for kittens abduction
 */
@RestController
@RequestMapping("/api/v1")
public class LocationFinderConroller {

	@Autowired
	CoordinatesFinderAndValidator coordinatesFinderAndValidator;

	@Autowired
	DirectionService directionService;

	/**
	 * Gets the email which needs to be included for forensic direction API
	 *
	 * @param email to fetch forensic API
	 * 
	 * @return the location info and result after validating
	 */
	@RequestMapping("/locationfinder")
	public Locationinfo locate(@RequestParam("email") String email)
			throws JsonMappingException, JsonProcessingException {

		return coordinatesFinderAndValidator
				.resolveAndValidateLocationCordinates(directionService.getDirectionsmoved(email), email);
	}

}
