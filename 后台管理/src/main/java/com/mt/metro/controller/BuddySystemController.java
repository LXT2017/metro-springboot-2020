package com.mt.metro.controller;

import com.mt.metro.entity.Addfriend;
import com.mt.metro.service.BuddySystemService;
import com.mt.metro.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("buddy")
public class BuddySystemController {

    @Autowired
    BuddySystemService buddySystemService;


    /**
     * 精确搜索好友
     * @param id
     * @return
     */
    @GetMapping("getFriendsById")
    public ResponseResult getFriendsById(int id,int friendId){
        return buddySystemService.getMyFriendsById(id,friendId);
    }


    // 搜索附近的好友，通过地理位置
    @GetMapping("/getFriends")
    public ResponseResult getFriends(int id,@RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "15",required = false)int pageSize){
        return buddySystemService.getFriends(id,pageNum,pageSize);
    }

    /**
     * 按照名字模糊搜索
     * @param id
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/getFriendsByName")
    public ResponseResult getFriendsByName(int id, @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "15",required = false)int pageSize, String name){
        return buddySystemService.getMyFriendsByName(id,pageNum,pageSize,name);

    }

    // 获得我的好友列表
    @GetMapping("/getMyFriends")
    public ResponseResult getMyFriends(int id){
        return buddySystemService.getMyFriends(id);
    }


    /**
     * 好友申请
     * 传入用户和好友的id
     */
    @PostMapping("/postFriendRequest")
    public ResponseResult postFriendRequest(Addfriend addfriend){
        return buddySystemService.postFriendRequest(addfriend);
    }

    /**
     * 申请列表和回复
     * @param id
     * @return
     */
    @GetMapping("/getFriendAskInfo")
    public ResponseResult getFriendAskInfo(int id){
        return buddySystemService.getFriendAskInfo(id);
    }


    // 同意
    @PostMapping("/AgreeRequest")
    public ResponseResult postAgreeRequest(int friend1, int friend2){
        return buddySystemService.postAgreeRequest(friend1,friend2);
    }

    // 拒绝
    @PostMapping("/RefuseRequest")
    public ResponseResult postRefuseRequest(int friend1, int friend2){
        return buddySystemService.postRefuseRequest(friend1,friend2);
    }


    // 删除当前用户的申请状态
    @PostMapping("/delFriendInfo")
    public ResponseResult delFriendAskInfo(int id){
        return buddySystemService.delFriendInfo(id);
    }

    // 删除好友
    @PostMapping("/delFriend")
    public ResponseResult delFriendAsk(int friend1, int friend2){
        return buddySystemService.delFriend(friend1,friend2);
    }
}
