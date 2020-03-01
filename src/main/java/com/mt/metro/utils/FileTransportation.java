package com.mt.metro.utils;


import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Component
public class FileTransportation {

    private final Logger logger = LogManager.getLogger(FileTransportation.class);

    public  String headPicUpload(MultipartFile file) throws Exception {
            // 首先校验图片格式
            List<String> imageType = Lists.newArrayList("jpg","jpeg", "png", "bmp", "gif");
            // 获取文件名，带后缀
            String originalFilename = file.getOriginalFilename();
            // 获取文件的后缀格式
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
            if (imageType.contains(fileSuffix)) {
                // 只有当满足图片格式时才进来，重新赋图片名，防止出现名称重复的情况
                String uuid = UUID.randomUUID()
                        .toString()
                        .replaceAll("-","");
                String newFileName = uuid.concat(".").concat(fileSuffix);

                // 该方法返回的为当前项目的工作目录，即在哪个地方启动的java线程
                //String dirPath = System.getProperty("user.dir");
                String dirPath = "/contest"+File.separator+"data";
                String path = File.separator + "headPicUploadImg" + File.separator + newFileName;

                File destFile = new File(dirPath + path);
                if (!destFile.getParentFile().exists()) {
                    destFile.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(destFile);
                    // 将相对路径返回给前端
                    return path;
                } catch (IOException e) {
                    logger.error("upload pic error");
                    throw new RuntimeException("上传错误");
                }
            } else {
                // 非法文件
                logger.error("the picture's suffix is illegal");
                throw new Exception("上传图片为非法文件");
            }
    }

}
