package com.app.yoribogo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/member/*")
public class MemberController {

    @GetMapping("join")
    public void goToEmailJoin() {;}

    @GetMapping("expiredLink")
    public void goToExpiredLink() {;}

    @GetMapping("findPassword")
    public void goToFindPassword() {;}

    @GetMapping("findPasswordSend")
    public void goToFindPasswordSend() {;}

    @GetMapping("joinComplete")
    public void goToJoinComplete() {;}

    @GetMapping("login")
    public void goToLoginMain() {;}

    @GetMapping("verification")
    public void goToVerification() {;}

    @GetMapping("mainPost")
    public void goToPost(){;}

    @GetMapping("introMain")
    public void goToIntroMain() {;}
}