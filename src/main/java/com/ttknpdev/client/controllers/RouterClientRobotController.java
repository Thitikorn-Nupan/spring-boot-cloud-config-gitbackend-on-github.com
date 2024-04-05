package com.ttknpdev.client.controllers;

import com.ttknpdev.client.entities.Robot;
import com.ttknpdev.client.service.RobotServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/robot")
public class RouterClientRobotController {
    private RobotServiceResponse robotServiceResponse;

    @Value("${robot.url}")
    private String robotUrl;

    @Autowired
    public RouterClientRobotController(RobotServiceResponse robotServiceResponse) {
        this.robotServiceResponse = robotServiceResponse;
    }

    @GetMapping(value = "/reads")
    private ResponseEntity<List<Robot>> retrieveAllRobotFromGitBackendServer() {
        List<Robot> robots = robotServiceResponse.reads(robotUrl+"/reads");
        return ResponseEntity
                .ok()
                .body(robots);
    }

    @GetMapping(value = "/read")
    private ResponseEntity<Robot> retrieveRobotFromGitBackendServer(@RequestParam Long id) {
        Robot robot = robotServiceResponse.read(robotUrl+"/read?id="+id);
        return ResponseEntity
                .ok()
                .body(robot);
    }

    @PostMapping(value = "/create")
    private ResponseEntity<Robot> addRobotFromGitBackendServer(@RequestBody Robot robot) {
        Robot robotResponse = robotServiceResponse.create(robotUrl+"/create",robot);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(robotResponse);
    }

    @DeleteMapping(value = "/delete")
    private ResponseEntity<Boolean> removeRobotFromRobotMicroservice(@RequestParam(required = false) Long id){
        Boolean response = robotServiceResponse.delete(robotUrl+"/delete?id="+id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }

    @PutMapping(value = "/update")
    private ResponseEntity<Robot> editRobotFromRobotMicroservice(@RequestParam(required = false) Long id,@RequestBody Robot robot){
        Robot robotResponse = robotServiceResponse.update(robotUrl+"/update?id="+id,robot);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(robotResponse);
    }

}
