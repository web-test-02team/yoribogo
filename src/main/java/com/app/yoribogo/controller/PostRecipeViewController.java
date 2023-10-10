package com.app.yoribogo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller 를 이용하여 View 제공
@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
public class PostRecipeViewController {
    @GetMapping("recipelist")
    public void showRecipeList() {

//        model.addAttribute("postId", id);
    }
}

