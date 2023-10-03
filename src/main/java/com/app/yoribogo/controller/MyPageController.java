package com.app.yoribogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {

    @GetMapping("mycomment")
    public  void goToMyComment(){;}

    @GetMapping("myfavorite")
    public void goToMyFavorite(){;}

    @GetMapping("myinfo")
    public void goToMyInfo(){;}

    @PostMapping("myinfo")
    public void updateProfile(@RequestParam("uuid") List<String> uuids, @RequestParam("uploadFile") List<MultipartFile> uploadFiles){

    }

    @GetMapping("mypurchase")
    public void goToMyPurchase(){;}

    @GetMapping("myrecipe")
    public void goToMyRecipe(){;}

    @GetMapping("myreview")
    public void goToMyReview(){;}

    @GetMapping("othersreview")
    public void goToOthersReview(){;}

}
