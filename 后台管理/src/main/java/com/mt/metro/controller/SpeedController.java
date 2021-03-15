package com.mt.metro.controller;


import com.mt.metro.utils.ResponseResult;
import com.mt.metro.service.SpeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("speed")
public class SpeedController {

    @Autowired
    SpeedService speedService;


    @GetMapping("/getMetroInfo")
    public ResponseResult getMetroInfo(String current, String destination){
        return speedService.getMetroInfo(current, destination);
    }



    @PostMapping("/settlement")
    public ResponseResult settlement(int id, int coin, int distance, int loseCoin){

        // UserCoin=UserCoin-LoseCoin+Coin
        return speedService.settlement(id,coin,distance,loseCoin);
    }
}
