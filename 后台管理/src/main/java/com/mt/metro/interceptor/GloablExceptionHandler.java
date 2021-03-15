package com.mt.metro.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.mt.metro.utils.ResponseResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author jinbin
 * @date 2018-07-08 22:37
 */
@ControllerAdvice
public class GloablExceptionHandler {

    private final Logger logger = LogManager.getLogger(GloablExceptionHandler.class);


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        ResponseResult<JSONObject> responseResult;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", msg);
        logger.error("系统异常");
        responseResult = new ResponseResult<>(501, "failure", jsonObject);
        return responseResult;
    }


    /**
     * 缺少请求参数异常
     *
     * @param ex HttpMessageNotReadableException
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handleHttpMessageNotReadableException(
            MissingServletRequestParameterException ex) {
        logger.error("缺少请求参数，{}", ex.getMessage());
        return new ResponseResult<>(501, "缺少必要的请求参数", null);
    }

    /**
     * 空指针异常
     *
     * @param ex NullPointerException
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object handleTypeMismatchException(NullPointerException ex) {
        logger.error("空指针异常，{}", ex);
        return new ResponseResult<>(501, "空指针异常了", null);
    }
}
