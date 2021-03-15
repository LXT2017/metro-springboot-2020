package com.mt.metro.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Shawn
 */
@RestController
@RequestMapping("web")
public class WebSocketController {

    @Autowired
    WebSocketServer webSocketServer;


    /**
     * 发送消息给所有在线用户
     * {xxx:xxx}格式
     * @param msg
     * @return
     */
    @GetMapping("/sendMessage")
    public int sendMessage(@RequestParam("msg") String msg){
        System.out.println(msg);
        try {
            webSocketServer.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 200;
    }

    /**
     * 发送特定消息给xxx
     * @param id
     * @param msg
     * @return
     * @throws IOException
     */
    @PostMapping("/sendInfo")
    public int sendInfo(String msg,String id) throws IOException {
        int i =WebSocketServer.sendInfo(msg,id);
        System.out.println(i);
        return i;
    }


    /**
     * 统计在线人数
     */
    @GetMapping("/getOnlineNum")
    public int getOnlineNum(){
        return WebSocketServer.getOnlineCount();
    }

    /**
     * 群推送在线用户
     */
    @PostMapping("/sendAll")
    public int sendAll(String msg){
        WebSocketServer.sendAll(msg);
        return 200;
    }
}
