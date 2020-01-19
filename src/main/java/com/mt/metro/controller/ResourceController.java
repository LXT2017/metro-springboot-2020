package com.mt.metro.controller;


import com.mt.metro.annotation.PassToken;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.service.ResourceService;
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

    @PassToken
    @GetMapping("/getResource")
    public ResponseResult getResource(){
        ResponseResult responseResult = new ResponseResult(100,"success",resourceService.getParam());
        return responseResult;
    }

}
