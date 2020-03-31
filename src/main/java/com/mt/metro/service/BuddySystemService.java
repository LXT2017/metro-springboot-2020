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
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
     * 搜索附近好友
     * @param id
     * @return
     */
    public ResponseResult getFriends(int id,int pageNum,int pageSize) {
        List<Integer> myFriendsIdList = getMyFriendsIdList(id);
        System.out.println(myFriendsIdList);
        PageHelper.startPage(pageNum,pageSize);
        // 要去除我已经添加了的好友
        List<MyFriend> myFriendList = this.addfriendMapper.findFriendsByLocation(id,myFriendsIdList);

        PageInfo<MyFriend> pageInfo = new PageInfo<>(myFriendList);


        return new ResponseResult(200,"success",pageInfo);
    }


    /**
     * 按照Id搜索好友
     * @param id
     * @return
     */
    public ResponseResult getMyFriendsById(int id,int friendId) {
        MyFriend myFriend = addfriendMapper.selectUserById(friendId);
        if(myFriend == null){
            return new ResponseResult(501,"id错误，没有找到该好友",null);
        }
        if (getMyFriendsIdList(id).contains(myFriend.getId())){
            return new ResponseResult(501,"您已添加对方为好友",null);
        }
        return new ResponseResult(200,"sucess",myFriend);
    }


    /**
     * 好友按照名字模糊搜索
     */
    public ResponseResult getMyFriendsByName(int id, int pageNum, int pageSize, String name){
        System.out.println(name);
        List<Integer> friendsIdList = getMyFriendsIdList(id);
        PageHelper.startPage(pageNum,pageSize);
        List<MyFriend> myFriendList = addfriendMapper.selectUserByName(id,name,friendsIdList);
        PageInfo<MyFriend> pageInfo = new PageInfo<>(myFriendList);
        System.out.println(pageInfo);
        return new ResponseResult(200,"sucess",pageInfo);
    }

    /**
     * 获得我的好友的id序号
     */
    private List<Integer> getFriendsIdList(int id){
        List<Friend> friendList = friendMapper.findFriendById(id);

        if (CollectionUtils.isEmpty(friendList)){
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
        return myfriendList;
    }

    //缓存，时间2小时
    @Cacheable(value = "friends",key = "#id")
    public List<Integer> getMyFriendsIdList(int id){
        return getFriendsIdList(id);
    }

    //更新缓存
    @CachePut(value = "friends",key = "#id")
    public List<Integer> updateMyFriendsIdList(int id){
        return getFriendsIdList(id);
    }

    /**
     * 返回我的好友列表
     * @param id
     * @return
     */
    public ResponseResult getMyFriends(int id){
        List<Integer> myfriendList = getMyFriendsIdList(id);
        if(myfriendList == null){
            return new ResponseResult(200,"您还没有好友",null);
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
        if(getMyFriendsIdList(addfriend.getFriend1()).contains(addfriend.getFriend2())){
            return new ResponseResult(501,"对方已经是您的好友，无需重复添加",null);
        }
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
        // 及时更新，可以引入消息队列
        updateMyFriendsIdList(friend1);
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
