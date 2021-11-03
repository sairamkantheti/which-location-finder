package com.which.locator.model;


import java.util.List;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "directions" })
public class DirectionsMoved {

	@JsonProperty("directions")
	private List<String> directions = null;



	@JsonProperty("directions")
	public List<String> getDirections() {
		return directions;
	}

	@JsonProperty("directions")
	public void setDirections(List<String> directions) {
		this.directions = directions;
	}



}