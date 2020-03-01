package com.mt.metro.service;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mt.metro.entity.Addfriend;
import com.mt.metro.entity.Friend;
import com.mt.metro.entity.MyFriend;
import com.mt.metro.mapper.AddfriendMapper;
import com.mt.metro.mapper.FriendMapper;
import com.mt.metro.mapper.UserMapper;
import com.mt.metro.utils.JsonFilter;
import com.mt.metro.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuddySystemService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    FriendMapper friendMapper;
    @Autowired
    AddfriendMapper addfriendMapper;


    /**
     * 查找好友来进行添加
     * @param id
     * @return
     */
    public ResponseResult getFriends(int id,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<MyFriend> myFriendList = this.addfriendMapper.findFriendsByLocation(id);

        PageInfo<MyFriend> pageInfo = new PageInfo<>(myFriendList);


        System.out.println(myFriendList);
        return new ResponseResult(200,"success",pageInfo);
    }

    /**
     * 返回我的好友列表
     * @param id
     * @return
     */
    public ResponseResult getMyFriends(int id){
        List<Friend> friendList = friendMapper.findFriendById(id);

        if (CollectionUtils.isEmpty(friendList)){
            System.out.println("控制");
            return null;
        }
        List<Integer> myfriendList = new ArrayList();
        for(Friend friend:friendList) {
            if(id == friend.getFriend1()){
                myfriendList.add(friend.getFriend2());
            } else {
                myfriendList.add(friend.getFriend1());
            }
        }
        List<MyFriend> list = userMapper.findFriendByList(myfriendList);
        System.out.println(list);
        return new ResponseResult(200,"success",list);
    }


    /**
     * 申请好友请求
     * @param addfriend
     * @return
     */
    public ResponseResult postFriendRequest(Addfriend addfriend){
        addfriend.setFriend1_allow(Addfriend.ALLOW);
        addfriendMapper.addFriend(addfriend);
        return new ResponseResult(200,"已成功发送申请",null);
    }


    /**
     * 查询请求状态
     * @param id
     * @return
     */
    public ResponseResult getFriendAskInfo(int id){

        Map map = new HashMap();

        // 申请列表
        List<Addfriend> askList = new ArrayList<>();
        // 回应列表
        List<Addfriend> responseList = new ArrayList<>();


        // 申请列表
        List<Addfriend> friendAskList = addfriendMapper.findFriendRequest(id);
        for (Addfriend addfriend:friendAskList) {
            Addfriend addfriendResult = addfriendMapper.findUserByUserId(addfriend.getFriend1());
            askList.add(addfriendResult);
        }
        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(Addfriend.class, "id","friendName");


        map.put("requestList",JsonFilter.getJsonFilter(askList,filter1));


        // 回复列表
        List<Addfriend> friendResponseList = addfriendMapper.responseMessage(id);
        for (Addfriend addfriend:friendResponseList) {
            Addfriend addfriendResult = addfriendMapper.findUserByUserId(addfriend.getFriend2());
            addfriendResult.setResponse(addfriend.getFriend2_allow());
            responseList.add(addfriendResult);
        }

        SimplePropertyPreFilter filter2 = new SimplePropertyPreFilter(Addfriend.class, "id","friendName","response");
        map.put("responseList", JsonFilter.getJsonFilter(responseList,filter2));


        return new ResponseResult(200,"sucess",map);
    }


    /**
     * 同意好友请求
     * @param friend1
     * @param friend2
     * @return
     */
    public ResponseResult postAgreeRequest(int friend1,int friend2){
        String response = Addfriend.ALLOW;
        addfriendMapper.friendRequest(friend1,friend2,response);
        Friend friend = new Friend();
        friend.setFriend1(friend1);
        friend.setFriend2(friend2);
        friendMapper.insert(friend);

        return new ResponseResult(200,"相见恨晚，快去聊天吧",null);
    }


    /**
     * 拒绝好友请求
     * @param friend1
     * @param friend2
     * @return
     */
    public ResponseResult postRefuseRequest(int friend1,int friend2){
        String response = Addfriend.DISALLOW;
        addfriendMapper.friendRequest(friend1,friend2,response);
        return new ResponseResult(200,"铁石心肠，成大事者也",null);
    }

    // 删除状态
    public ResponseResult delFriendInfo(int id) {
        addfriendMapper.delFriendRequest(id);
        return new ResponseResult(200,"success",null);
    }

    // 删除好友
    public ResponseResult delFriend(int friend1, int friend2) {
        friendMapper.deleteFriend(friend1,friend2);
        return new ResponseResult(200,"success",null);
    }


}
