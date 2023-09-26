package com.app.yoribogo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@Slf4j
@RequestMapping("/main/*")
public class MainController {
    @GetMapping("main")
    public void goToMain(){;}

    @GetMapping("mainPost")
    public void goToPost(){;}
    @GetMapping("introMain")
    public void goToIntroMain() {;}
}
