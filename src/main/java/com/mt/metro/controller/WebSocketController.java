package com.mt.metro.controller;

import com.mt.metro.common.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("web")
public class WebSocketController {

    @Autowired
    WebSocketServer webSocketServer;

    @GetMapping("/sendMessage")
    public String sendMessage(String msg){
        System.out.println(msg);
        try {
            webSocketServer.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "OK";
    }


    @GetMapping("/senfInfo")
    public String sendInfo(String id,String msg) throws IOException {
        WebSocketServer.sendInfo(msg,id);
        return "OK";
    }
}
