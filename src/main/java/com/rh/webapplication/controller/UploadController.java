package com.rh.webapplication.controller;

import com.rh.webapplication.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        log.info("name:{}", name);
        log.info("age:{}", age);
        log.info("file:{}", file.getOriginalFilename());

        String originalFilename = file.getOriginalFilename();

        String extension=originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName= UUID.randomUUID().toString()+extension;

        file.transferTo(new File("/Users/renhonglow/Library/Mobile Documents/com~apple~CloudDocs/JAVAWEB/webapplication/src/main/resources/image"+
                file.getOriginalFilename()));
        return Result.success();
    }
}
