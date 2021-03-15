package com.mt.metroadmin.controller;


import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "数据统计接口")
@RequestMapping("statistic")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/getAllCity")
    @ApiOperation(value = "获取所有城市接口", notes = "获取到已经注册的所有城市名字，后面查询每个城市的用户日活跃量有用")
    public ResponseResult getAllCity(){
        return statisticsService.getAllCity();
    }


    @GetMapping("/getTotalVisitsNow")
    @ApiOperation(value = "获取系统总访问量接口", notes = "days是输入过去多少天到昨日的数据，比如过去7天的数据，你可以自己定义，" +
            "返回结果是一天一个访问数据，你可以做数据图标,statime是时间")
    public ResponseResult getTotalVisitsNow(int days){
        if(days<=0){
            return new ResponseResult(400,"请输入正确的days",null);
        }
        return statisticsService.getTotalVisitsNow(days);
    }


    @GetMapping("/getTotalVisitsFrom")
    @ApiOperation(value = "获取系统总访问量接口,查询区间自定", notes = "before输入起始查询点，now输入终止查询点，输入格式为 2020/2/2或者2020-12-2，切忌")
    public ResponseResult getTotalVisitsFrom(String before,String now){
        return statisticsService.getTotalVisitsFrom(before,now);
    }


    @GetMapping("/getCityVisitsNow")
    @ApiOperation(value = "获取一个城市总访问量接口", notes = "days是输入过去多少天到昨日的数据，比如过去7天的数据，你可以自己定义，" +
            "返回结果是一天一个访问数据，你可以做数据图标,statime是时间，这个和之前差不多，就是多了一个城市，城市的名字需要是之前获取的." +
            "这里的citynum才是一个城市的日访问量，total是所有城市的，可用可不用")
    public ResponseResult getCityVisitsNow(int days,String city){
        if(days<=0){
            return new ResponseResult(400,"请输入正确的days",null);
        }
        return statisticsService.getCityVisitsNow(days ,city);
    }


    @GetMapping("/getCityVisitsFrom")
    @ApiOperation(value = "获取一个城市总访问量接口,查询区间自定", notes = "before输入起始查询点，now输入终止查询点，输入格式为 2020/2/2或者2020-12-2，切忌," +
            "这里和之前多了一个city。这里的citynum才是一个城市的日访问量，total是所有城市的，可用可不用")
    public ResponseResult getCityVisitsFrom(String before,String now,String city){
        return statisticsService.getCityVisitsFrom(before,now,city);
    }


    @GetMapping("/getOnlineNum")
    @ApiOperation(value = "获取当前在线用户的人数", notes = "只获取当前在线的")
    public ResponseResult getOnlineNum(){
        return statisticsService.getOnlineNum();
    }
}
