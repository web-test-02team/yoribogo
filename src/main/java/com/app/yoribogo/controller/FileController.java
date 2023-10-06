package com.app.yoribogo.controller;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/file/*")
public class FileController {
//    프로필 이미지 업로드 여러개
    @PostMapping("profile-upload")
    @ResponseBody
    public String profileUpload(@RequestParam("uploadFile") List<MultipartFile> uploadFiles) throws IOException {
        String rootPath = "C:/upload/" + getPath();
        String uuid = UUID.randomUUID().toString();
        File file = new File(rootPath);
        if (!file.exists()){
            file.mkdirs();
        }

        uploadFiles.get(0).transferTo(new File(rootPath, uuid + "_" + uploadFiles.get(0).getOriginalFilename()));
        if(uploadFiles.get(0).getContentType().startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuid + "_" + uploadFiles.get(0).getOriginalFilename()));
            Thumbnailator.createThumbnail(uploadFiles.get(0).getInputStream(), out, 200, 200);
            out.close();
        }

        return uuid;
    }

//    배경 이미지 업로드 여러개
    @PostMapping("background-upload")
    @ResponseBody
    public String backgroundUpload(@RequestParam("uploadFile") List<MultipartFile> uploadFiles) throws IOException {
        String rootPath = "C:/upload/" + getPath();
        String uuid = UUID.randomUUID().toString();
        File file = new File(rootPath);
        if (!file.exists()){
            file.mkdirs();
        }

        uploadFiles.get(0).transferTo(new File(rootPath, uuid + "_" + uploadFiles.get(0).getOriginalFilename()));
        if(uploadFiles.get(0).getContentType().startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuid + "_" + uploadFiles.get(0).getOriginalFilename()));
            Thumbnailator.createThumbnail(uploadFiles.get(0).getInputStream(), out, 800, 296);
            out.close();
        }

        return uuid;
    }

//    프로필 이미지 업로드 1개
//    @PostMapping("profile-upload")
//    @ResponseBody
//    public String profileUpload(@RequestParam("profileUpload") MultipartFile profileUpload) throws IOException {
//        String rootPath = "C:/upload/" + getPath();
//        String uuid = UUID.randomUUID().toString();
//        File file = new File(rootPath);
//        if (!file.exists()){
//            file.mkdirs();
//        }
//
//        profileUpload.transferTo(new File(rootPath, uuid + "_" + profileUpload.getOriginalFilename()));
//        if(profileUpload.getContentType().startsWith("image")){
//            FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuid + "_" + profileUpload.getOriginalFilename()));
//            Thumbnailator.createThumbnail(profileUpload.getInputStream(), out, 200, 200);
//            out.close();
//        }
//
//        return uuid;
//    }

//    배경 이미지 업로드 1개
//    @PostMapping("background-upload")
//    @ResponseBody
//    public String backgroundUpload(@RequestParam("backgroundUpload") MultipartFile backgroundUpload) throws IOException {
//        String rootPath = "C:/upload/" + getPath();
//        String uuid = UUID.randomUUID().toString();
//        File file = new File(rootPath);
//        if (!file.exists()){
//            file.mkdirs();
//        }
//
//        backgroundUpload.transferTo(new File(rootPath, uuid + "_" + backgroundUpload.getOriginalFilename()));
//        if(backgroundUpload.getContentType().startsWith("image")){
//            FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuid + "_" + backgroundUpload.getOriginalFilename()));
//            Thumbnailator.createThumbnail(backgroundUpload.getInputStream(), out, 800, 296);
//            out.close();
//        }
//
//        return uuid;
//    }

    @GetMapping("display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload", fileName));
    }

    private String getPath() { return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));}
}
