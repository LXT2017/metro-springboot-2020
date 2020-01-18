package com.mt.metro.controller;


import com.mt.metro.annotation.PassToken;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @PassToken
    @GetMapping("/getResource")
    public ResponseResult getResource(){
        ResponseResult responseResult = new ResponseResult(100,"success",resourceService.getParam());
        return responseResult;
    }

}
