package com.mt.metro.controller;


import com.mt.metro.common.ResponseResult;
import com.mt.metro.entity.Dressup;
import com.mt.metro.entity.DressupSort;
import com.mt.metro.service.DressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mall")
public class DressController {

    private final DressService dressService;

    public DressController(DressService dressService) {
        this.dressService = dressService;
    }


    @GetMapping("/getDressSort")
    public ResponseResult getDressSort(){
        List<DressupSort> list = dressService.getDressSort();
        ResponseResult result = new ResponseResult(200,"success",list);
        return result;
    }


    //获取某一个装扮的资源
    @GetMapping("/getDress")
    public ResponseResult getDress(Dressup dressup){
        ResponseResult result;
        if(dressup.getDressupId() == null){
            result = new ResponseResult(400,"id传入值为空",null);
            return result;
        }

        List<Dressup> list = dressService.getDress(dressup);
        result = new ResponseResult(200,"success",list);
        return result;
    }

}
