package com.ttknpdev.client.service;

import com.ttknpdev.client.entities.Address;
import com.ttknpdev.client.entities.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RobotServiceResponse {
    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private HttpEntity entity;
    @Autowired
    public RobotServiceResponse(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Robot> reads(String urlReads) {
        Robot[] objects = restTemplate.getForObject(urlReads, Robot[].class);
        List<Robot> robots = null;
        if (objects != null) {
            robots = Arrays.asList(objects);
        }
        return robots;
    }

    public Robot read(String urlRead) {
        Robot robot = restTemplate.getForObject(urlRead, Robot.class);
        return robot;
    }

    public Robot create(String urlCreate, Robot robot) {
        // *** way to pass json body on request
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Robot robotResponse = restTemplate.postForObject(urlCreate ,robot, Robot.class);
        return robotResponse;
    }

    public Boolean delete(String urlDelete) {
        ResponseEntity<Boolean> response = restTemplate.exchange(urlDelete, HttpMethod.DELETE, null, Boolean.class);
        return response.getBody();
    }

    public Robot update(String urlUpdate, Robot robot) {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        entity = new HttpEntity<Robot>(robot);
        ResponseEntity<Robot> response = restTemplate.exchange(urlUpdate, HttpMethod.PUT, entity, Robot.class);
        return response.getBody();
    }
}
