package com.mt.metroadmin.controller;


import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户查询接口")
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "用户查询", notes = "查询反馈,返回用户，id默认是0 ，则是查询所有用户,此时可以自行设计每一页的大小；而id精确值则查询某一特定用户" +
            "时，后面两个参数自动失效")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "用户的id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "第几页", required = false, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "每一页有几条数据", required = false, dataType = "int")
    })
    @GetMapping("/getUser/{id}")
    public ResponseResult getUser(@RequestParam(value = "id",defaultValue ="0",required = false) int id , @RequestParam(value = "pageNum",defaultValue ="1" ,required = false)int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "15",required = false)int pageSize){
        return userService.getUser(id,pageNum,pageSize);
    }



    @ApiOperation(value = "用户模糊查询", notes = "根据用户的昵称进行模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "nickname", value = "用户的昵称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "第几页", required = false, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "每一页有几条数据", required = false, dataType = "int")
    })
    @GetMapping("/getUserFuzzy")
    public ResponseResult getUserFuzzy(String nickname ,@RequestParam(value = "pageNum",defaultValue ="1" ,required = false)int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "15",required = false)int pageSize){
        return userService.getUserFuzzy(nickname,pageNum,pageSize);
    }



    @ApiOperation(value = "查询用户的具体信息", notes = "查询用户的具体信息")
    @GetMapping("/getUserDetail")
    public ResponseResult getUserDetail(int id){
        return userService.getUserDetail(id);
    }



    @ApiOperation(value = "推送消息到具体用户接口", notes = "推送消息到具体用户，id从上面获取，可以进入每个用户的数据页面进行推送")
    @GetMapping("/pushMessageToUser")
    public ResponseResult pushMessageToUser(int id,String message){
        return userService.pushMessageToUser(String.valueOf(id),message);
    }


    @ApiOperation(value = "推送消息群发接口", notes = "推送消息到所有在线用户")
    @GetMapping("/pushMessage")
    public ResponseResult pushMessage(String message){
        return userService.pushMessage(message);
    }
}
