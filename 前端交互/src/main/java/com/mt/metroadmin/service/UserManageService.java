package com.mt.metroadmin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.entity.Feedback;
import com.mt.metroadmin.entity.Notice;
import com.mt.metroadmin.mapper.FeedbackMapper;
import com.mt.metroadmin.mapper.NoticeMapper;
import com.mt.metroadmin.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserManageService {

    @Resource
    RedisTemplate redisTemplate;

    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    FeedbackMapper feedbackMapper;



    /**
     * 发布公告
     * @param content
     * @param duration
     * @return
     */
    public ResponseResult ReleaseNotice(String content,int duration){
        if(duration<=0){
            duration = 1;
        }
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("notice",content,duration, TimeUnit.HOURS);
        Notice notice = new Notice();
        notice.setContent(content);
        notice.setDuration(duration);
        notice.setNoticeDate(Time.getDateCurrentTime());
        noticeMapper.insertSelective(notice);
        return new ResponseResult(200,"success",null);
    }


    /**
     * 查询用户反馈信息
     * @return
     */
    public ResponseResult getFeedBack(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Feedback> feedback = feedbackMapper.selectUserFeedBack();
        PageInfo<Feedback> pageInfo = new PageInfo<>(feedback);
        return new ResponseResult(200,"sucess",pageInfo);
    }



}
