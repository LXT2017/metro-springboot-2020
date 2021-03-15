package com.mt.metroadmin.service;

import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.entity.Parameter;
import com.mt.metroadmin.mapper.ParameterMapper;
import com.mt.metroadmin.utils.FileTransportation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

    @Autowired
    FileTransportation fileTransportation;

    @Autowired
    ParameterMapper parameterMapper;

    @Transactional
    public ResponseResult upload(MultipartFile multipartFile, int option) throws Exception {
        String path = fileTransportation.fileUpload(multipartFile,"background");
        Parameter parameter = new Parameter();
        if(option==1){
            parameter.setPuzzleMusic(path);
        }else if(option==2){
            parameter.setGameMusic(path);
        }else if(option==3){
            parameter.setPuzzlePic(path);
        }else if(option==4){
            parameter.setGamePic(path);
        }
        parameterMapper.updateByPrimaryKeySelective(parameter);
        return new ResponseResult(200,"success",path);
    }
}
