package com.ttknpdev.client.command;

import com.ttknpdev.client.entities.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestTemplateRequest {
    private static final Logger log = LoggerFactory.getLogger(RestTemplateRequest.class);
    /**
      RestTemplate is a class within the Spring framework we will understand how to use RestTemplate for invoking REST APIs of different shapes.
      Once the above spring application is up and running,
      test all Spring rest APIs and logging results with the below Spring rest client
      (Making an HTTP GET Request to Obtain the JSON Response)
      to honestly we can use them(this class) instead Postman! ???
    */
    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private HttpEntity entity;
    private final String[] URLS_ON_CLOUD = {
            "http://localhost:8080/address" ,
            "http://localhost:8080/robot"
    };

    public RestTemplateRequest() {
        this.restTemplate = new RestTemplate();
    }

    private void createRobot() {
        // Use HttpHeaders to set the Request Headers.
        headers = new HttpHeaders();
        // *** way to pass json body on request
        headers.setContentType(MediaType.APPLICATION_JSON);
        Robot robot =new Robot(0L,"RX-124","2011-03-21",5500000000.0,true);
        Robot robotResponse = restTemplate.postForObject( URLS_ON_CLOUD[1]+"/create",robot, Robot.class);
        log.debug("robotResponse {}",robotResponse);

    }
    public void deleteRobot() {
        ResponseEntity<Boolean> response = restTemplate.exchange(URLS_ON_CLOUD[1]+"/delete?id=1", HttpMethod.DELETE, null, Boolean.class);
        log.debug("response.getBody() {}",response.getBody());
    }

    public void updateRobot() {
        // Use HttpHeaders to set the Request Headers.
        headers = new HttpHeaders();
        // *** way to pass json body on request
        headers.setContentType(MediaType.APPLICATION_JSON);
        Robot robot =new Robot(0L,"RX-124","2012-03-21",15500000000.0,true);
        entity = new HttpEntity<Robot>(robot);
        ResponseEntity<Robot> response = restTemplate.exchange(URLS_ON_CLOUD[1]+"/update?id=6", HttpMethod.PUT, entity, Robot.class);
        log.debug("response.getBody() {}",response.getBody());

    }


    public static void main(String[] args) {
        // new MyRestTemplateRequest().createRobot();
        // new MyRestTemplateRequest().updateRobot();
        // new MyRestTemplateRequest().deleteRobot();
    }
}
