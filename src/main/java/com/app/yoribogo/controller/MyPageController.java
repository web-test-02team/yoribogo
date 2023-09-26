package com.app.yoribogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {

    @GetMapping("mycomment")
    public  void goToMyComment(){;}

    @GetMapping("myfavorite")
    public void goToMyFavorite(){;}

    @GetMapping("myinfo")
    public void goToMyInfo(){;}

    @GetMapping("mypurchase")
    public void goToMyPurchase(){;}

    @GetMapping("myrecipe")
    public void goToMyRecipe(){;}

    @GetMapping("myreview")
    public void goToMyReview(){;}

    @GetMapping("othersreview")
    public void goToOthersReview(){;}

}
