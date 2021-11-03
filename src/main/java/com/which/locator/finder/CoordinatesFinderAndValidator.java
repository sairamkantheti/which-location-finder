package com.which.locator.finder;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.which.locator.data.Locationinfo;
import com.which.locator.model.DirectionsMoved;
import com.which.locator.model.LocationValidation;
import com.which.locator.service.LocationValidationService;

@Component
public class CoordinatesFinderAndValidator {

	@Autowired
	LocationValidationService locationValidationService;
	
	private static final Logger logger = LogManager.getLogger(CoordinatesFinderAndValidator.class);

	
	/**
	 * CoordinatesFinderAndValidator finds the exact Coordinates and validates
	 * aganaist forensic location API
	 */
	public Locationinfo resolveAndValidateLocationCordinates(DirectionsMoved directionsMoved, String email)
			throws JsonProcessingException, JsonMappingException {
		int x = 0, y = 0;
		String direction = "north";
		List<String> instructions = directionsMoved.getDirections();

		for (String inst : instructions) {
			switch (inst) {
			case "forward":
				switch (direction) {
				case "north":
					y += 1;
					break;
				case "east":
					x += 1;
					break;
				case "south":
					y -= 1;
					break;
				case "west":
					x -= 1;
					break;
				}
				break;
			case "right":

				switch (direction) {
				case "north":
					direction = "east";
					break;
				case "east":
					direction = "south";
					break;
				case "south":
					direction = "west";
					break;
				case "west":
					direction = "north";
					break;
				}
				break;
			case "left":
				switch (direction) {
				case "north":
					direction = "west";
					break;
				case "east":
					direction = "north";
					break;
				case "south":
					direction = "east";
					break;
				case "west":
					direction = "south";
					break;
				}
				break;
			}
		}
		logger.info("########## found the correct cocrdinates for location ########");
		
		// this line of code validates the result against locations forensic API
		LocationValidation locationValidation = locationValidationService.validateResult(x, y, email);

		logger.info("########## validated coordinates using location API ########");
		
		// create response object
		Locationinfo locationInfo = getLocationInfo(x, y, direction, locationValidation);
		
		logger.info("########## response populated ########");
		return locationInfo;
	}

	private Locationinfo getLocationInfo(int x, int y, String direction, LocationValidation locationValidation) {
		Locationinfo locationInfo = new Locationinfo();
		StringBuilder coordinates = new StringBuilder();
		coordinates.append("(").append(String.valueOf(x)).append(",").append(String.valueOf(y)).append(")");
		locationInfo.setCordinates(coordinates.toString());
		locationInfo.setFacingdirection(direction);
		locationInfo.setValidationMessage(locationValidation.getMessage());
		return locationInfo;
	}

}
