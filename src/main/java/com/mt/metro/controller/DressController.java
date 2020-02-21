package com.mt.metro.controller;


import com.mt.metro.common.ResponseResult;
import com.mt.metro.service.DressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dress")
public class DressController {

    private final DressService dressService;

    public DressController(DressService dressService) {
        this.dressService = dressService;
    }


    //获取某一个种类的装扮的资源
    @GetMapping("/getDress")
    public ResponseResult getDress(int userId, int option) {
        ResponseResult result;
        if (option <= 0 || option > 4) {
            result = new ResponseResult(400, "参数错误", null);
            return result;
        }

        return dressService.getDress(userId,option);
    }

}
