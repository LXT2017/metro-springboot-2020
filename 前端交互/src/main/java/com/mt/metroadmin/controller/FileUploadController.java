package com.mt.metroadmin.controller;


import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(tags = "游戏背景音乐图片上传接口")
@RequestMapping("/file")
public class FileUploadController {


    @Autowired
    FileUploadService fileUploadService;

    @ApiOperation(value = "背景文件上传接口", notes = "根据option的不同，上传不同的背景文件，该模块不和移动端互通，为了给后台增加功能用的,在这个平台不能进行文件测试")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="MultipartFile", name = "multipartFile", value = "文件", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(paramType="int", name = "option", value =
                    "1上传拼图背景音乐;2上传跑酷背景音乐;3上传拼图背景图片;4上传跑酷背景图片", required = true, dataType = "int")
    })
    @PostMapping("/upload")
    public ResponseResult upload(MultipartFile multipartFile,int option) throws Exception {
        if(option > 4||option<1){
            return new ResponseResult(400,"option参数异常",null);
        }
        return fileUploadService.upload(multipartFile,option);

    }

}
