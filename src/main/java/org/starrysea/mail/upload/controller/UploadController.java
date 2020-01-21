package org.starrysea.mail.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
@Slf4j
public class UploadController {

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        File targetFile = new File(ResourceUtils.getURL("classpath:").getPath() + "/" + fileName);
        try {
            file.transferTo(Paths.get(targetFile.getAbsolutePath()));
            log.info("上传成功");
            return targetFile.getAbsolutePath();
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return "上传失败！";
    }
}

