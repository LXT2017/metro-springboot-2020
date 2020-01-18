package com.mt.metro.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.mt.metro.common.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jinbin
 * @date 2018-07-08 22:37
 */
@ControllerAdvice
public class GloablExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        ResponseResult<JSONObject> responseResult ;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", msg);
        responseResult = new ResponseResult<>(501,"failure",jsonObject);
        return responseResult;
    }
}
