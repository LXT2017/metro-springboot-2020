package com.mt.metro.controller;


import com.mt.metro.utils.ResponseResult;
import com.mt.metro.entity.Feedback;
import com.mt.metro.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("news")
@RestController
public class NewsController {


    @Autowired
    NewsService newsService;


    @PostMapping("/feedBack")
    public ResponseResult postFeedBack(Feedback feedback) {
        int code = 400;
        String msg = "fail";
        if (newsService.postFeedBack(feedback)) {
            code = 200;
            msg = "success";
        }
        return new ResponseResult(code, msg, null);
    }
}
