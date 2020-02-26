package com.mt.metro.controller;


import com.mt.metro.common.ResponseResult;
import com.mt.metro.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game")
public class GameController {


    @Autowired
    GameService gameService;


    /**
     * 记录本次游戏上线时间
     * @param id
     * @param option
     * @param loginTime
     * @return
     */
    @PostMapping("/loginGame")
    public ResponseResult loginGame(int id, int option, int loginTime){
        return gameService.loginGame(id, option, loginTime);
    }


    @GetMapping("/loginGameInfo")
    public ResponseResult loginGameInfo(int id){

        return gameService.loginGameInfo(id);
    }

}
