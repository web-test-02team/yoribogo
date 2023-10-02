package com.app.yoribogo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/post/*")
public class PostController {
    @GetMapping("read")
    public void goToRead() {;}

    @GetMapping("write")
    public void goToWrite() {;}

    @GetMapping("recipelist")
    public void goToRecipeList() {;}

    @GetMapping("reviewlist")
    public void goToReviewList() {;}
}