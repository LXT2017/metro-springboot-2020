package com.mt.metro.controller;

import com.mt.metro.common.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("imitations")
@RestController
public class Imitation {

    @GetMapping("/getVehicleInfo")
    public ResponseResult getVehicleInfo(@RequestParam(value = "station",defaultValue = "文泽路",required = false) String station){
        Map map = new HashMap();
        map.put("first subway",5);
        map.put("second subway",15);
        return new ResponseResult(200,"success",map);
    }

    @GetMapping("/getRemainingInfo")
    public ResponseResult getRemainingInfo(@RequestParam(value = "station",defaultValue = "文泽路",required = false)String station){
        Map map = new HashMap();
        map.put("remaining time",55);
        return new ResponseResult(200,"success",map);
    }

}
