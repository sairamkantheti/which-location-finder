# which-location-finder

 Springboot project is used to complete the task

## Requirements
Java: 1.8

maven


## windows Instrunctions:

* clone project
* open command prompt and navigete to project

* run **mvn clean install**

* run **mvn package**

* Navigate to target folder

* run project using (**java -jar location-finder.jar**)


## instructions to test result after build and startup

The location can be find by using the follwoing API after project setup. This API identifies the eact location using directions given by forensic team and validate using locations APi and returns the result

http://localhost:8080/api/v1/locationfinder?email=sairamkantheti1@gmail.com

email: is required for security. the same email is passed to direction API to fetch directions moved and locations

## important classes and purpouse

| class | purpouse | package |
|---|---|---|
| LocationFinderConroller | LocationFinderConroller is used for rest API. it is starting point for this requirement | com.which.locator.controller |
| DirectionService | It will integrate with forensic API and gets the directions used by mysterious girl | com.which.locator.service |
| CoordinatesFinderAndValidator| it has the business logic to find exact location fo mysterious woman and validation against location API | com.which.locator.finder |
|LocationValidationService|this service is used to validate result using locations forensic API | com.which.locator.service |
 



## Validation
Api response is validated aganaist location API and response even included the message returned by the API. The response from new API developed can be seen response result.PNG file

