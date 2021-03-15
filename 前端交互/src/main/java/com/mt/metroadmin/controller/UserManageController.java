package com.mt.metroadmin.controller;


import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.service.UserManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户行为管理接口")
@RequestMapping("userManage")
public class UserManageController {

    @Autowired
    UserManageService userManageService;


    @PostMapping("/releaseNotice")
    @ApiOperation(value = "发布公告接口", notes = "发布系统公告，设置公告时间，单位是小时")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content",required = true,value = "公告内容"),
            @ApiImplicitParam(name = "duration",required = true,value = "公告过期时间",dataType = "int")
    })
    public ResponseResult releaseNotice(String content, int duration) {
        return userManageService.ReleaseNotice(content, duration);
    }


    @ApiOperation(value = "查询反馈接口", notes = "查询反馈,返回用户的反馈信息，已经倒叙，即第一页为最新的")
    @GetMapping("/getFeedBack")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "第几页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "每一页有几条数据", required = true, dataType = "int")
    })
    public ResponseResult getFeedBack(int pageNum, int pageSize){

        return userManageService.getFeedBack(pageNum,pageSize);
    }





}
