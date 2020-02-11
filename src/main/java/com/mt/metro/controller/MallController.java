package com.mt.metro.controller;


import com.mt.metro.common.ResponseResult;
import com.mt.metro.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("mall")
public class MallController {

    @Autowired
    MallService mallService;

    /**
     * 查询积分商店的物品，按参数返回不同的商品
     * @param option
     * @return
     */
    @GetMapping("/getMallInfo")
    public ResponseResult getMallInfo(int option){
        if(option != 1 && option !=2){
            return new ResponseResult(400,"参数异常",null);
        }
        Map map = mallService.getMallInfo(option);
        return new ResponseResult(200,"success",map);
    }
}
