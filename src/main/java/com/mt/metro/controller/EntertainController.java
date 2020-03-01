package com.mt.metro.controller;


import com.mt.metro.utils.ResponseResult;
import com.mt.metro.service.EntertainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("entertainment")
public class EntertainController {

    @Autowired
    EntertainService entertainService;


    /**
     * 娱乐中心的结算
     * @param id
     * @param coin
     * @return
     */
    @PostMapping("/settlement")
    public ResponseResult settlement(int id, int coin){
        return entertainService.settlement(id,coin);
    }


}
