package com.rh.webapplication.controller;

import com.rh.webapplication.pojo.Result;
import com.rh.webapplication.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("name:{}", name);
//        log.info("age:{}", age);
//        log.info("file:{}", file.getOriginalFilename());
//
//        String originalFilename = file.getOriginalFilename();
//
//        String extension=originalFilename.substring(originalFilename.lastIndexOf("."));
//        String newFileName= UUID.randomUUID().toString()+extension;
//
//        file.transferTo(new File("/Users/renhonglow/Library/Mobile Documents/com~apple~CloudDocs/JAVAWEB/webapplication/src/main/resources/image"+
//                file.getOriginalFilename()));
//        return Result.success();
//    }
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("file:{}", file.getOriginalFilename());
        //将文件交给oss管理
        String url=aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());

        log.info("上传成功",url);

        return Result.success(url);

    }
}
