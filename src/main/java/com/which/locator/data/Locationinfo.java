package com.which.locator.data;

public class Locationinfo {

	String Coordinates;

	String Facingdirection;

	String validationMessage;

	public String getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}

	public String getCordinates() {
		return Coordinates;
	}

	public void setCordinates(String cordinates) {
		this.Coordinates = cordinates;
	}

	public String getFacingdirection() {
		return Facingdirection;
	}

	public void setFacingdirection(String facingdirection) {
		Facingdirection = facingdirection;
	}

}
