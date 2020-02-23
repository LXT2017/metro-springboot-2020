package com.mt.metro.service;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.mt.metro.common.JsonFilter;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.entity.Game;
import com.mt.metro.entity.GameExample;
import com.mt.metro.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    GameMapper gameMapper;

    /**
     * 用户注册时已经插入，此时只需更新
     * @param id
     * @param option
     * @param loginTime
     * @return
     */
    public ResponseResult loginGame(int id, int option, int loginTime){

        GameExample gameExample = new GameExample();
        GameExample.Criteria criteria = gameExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        Game game = new Game();
        int lastLoginTime = loginTime;
        switch (option){
            case 1:
                game.setEntertainment(lastLoginTime);
                break;
            case 2:
                game.setBodybuilding(lastLoginTime);
                break;
            case 3:
                game.setSpeedcontest(lastLoginTime);
                break;
        }
        gameMapper.updateByExampleSelective(game,gameExample);
        return  new ResponseResult(200,"success",null);
    }



    public ResponseResult loginGameInfo(int id) {
        // 过滤的字符
        PropertyFilter profilter = (object, name, value) -> {
            if (name.equalsIgnoreCase("id") || name.equalsIgnoreCase("userId") ) {
                //false表示last字段将被排除在外
                return false;
            }
            return true;
        };

        Game game = gameMapper.selectBySelective(id);
        return  new ResponseResult(200,"success", JsonFilter.getJsonPreFilter(game,profilter));
    }
}
