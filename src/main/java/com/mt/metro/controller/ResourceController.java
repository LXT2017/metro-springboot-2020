package com.mt.metro.controller;


import com.mt.metro.annotation.PassToken;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.common.Schedule;
import com.mt.metro.entity.Sign;
import com.mt.metro.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//资源
@RestController
@RequestMapping("resource")
public class ResourceController {

    final
    private ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Autowired
    Schedule schedule;

    @PassToken
    @GetMapping("/getResource")
    public ResponseResult getResource() {
        ResponseResult responseResult = new ResponseResult(200, "success", resourceService.getParam());
        return responseResult;
    }

    @PassToken
    @GetMapping("/getSign")
    public ResponseResult getSign() {
        Sign sign = resourceService.getquerySign();
        ResponseResult responseResult = new ResponseResult(200, "success", sign);
        return responseResult;
    }



    @GetMapping("/getParam")
    public ResponseResult getParam(){
        schedule.queryParam();
        schedule.querySign();
        schedule.getWeek();
        return new ResponseResult(200,"sud",null);
    }
}
