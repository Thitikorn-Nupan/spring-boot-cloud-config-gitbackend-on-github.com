package com.ttknpdev.service.controller;


import com.ttknpdev.service.entity.Robot;
import com.ttknpdev.service.logging.LogBack;
import com.ttknpdev.service.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = RobotRouterControl.DEFAULT_PATH)
public class RobotRouterControl {
    protected static final String DEFAULT_PATH = "/robot";
    private LogBack logBack;
    private CommonService commonService;

    @Autowired
    public RobotRouterControl(CommonService commonService) {
        this.commonService = commonService;
        logBack = new LogBack(RobotRouterControl.class);
    }

    @GetMapping(value = "/reads")
    private List<Robot> retrieveRobots() {
        logBack.log.info("You called http://localhost:8080{} api on spring cloud http://localhost:8888{} api",DEFAULT_PATH+"/reads",DEFAULT_PATH+"/reads");
        return commonService.reads();
    }

    @GetMapping(value = "/read")
    private Robot retrieveRobot(@RequestParam(required = false) Long id) {
        logBack.log.info("You called http://localhost:8080{} api on spring cloud http://localhost:8888{} api",DEFAULT_PATH+"/read?id="+id,DEFAULT_PATH+"/read?id="+id);
        return (Robot) commonService.read(id);
    }

    @PostMapping(value = "/create")
    private Robot addRobot(@RequestBody(required = false) Robot robot) {
        logBack.log.info("You called http://localhost:8080{} api on spring cloud http://localhost:8888{} api",DEFAULT_PATH+"/create",DEFAULT_PATH+"/create");
        return (Robot) commonService.create(robot);
    }

    @PutMapping(value = "/update")
    private Robot editRobot(@RequestParam(required = false) Long id,@RequestBody(required = false) Robot robot) {
        logBack.log.info("You called http://localhost:8080{} api on spring cloud http://localhost:8888{} api",DEFAULT_PATH+"/update?id="+id,DEFAULT_PATH+"/update?id="+id);
        return (Robot) commonService.update(robot,id);
    }

    @DeleteMapping(value = "/delete")
    private Boolean removeRobot(@RequestParam(required = false) Long id) {
        logBack.log.info("You called http://localhost:8080{} api on spring cloud http://localhost:8888{} api",DEFAULT_PATH+"/update?id="+id,DEFAULT_PATH+"/update?id="+id);
        return commonService.delete(id);
    }

}
