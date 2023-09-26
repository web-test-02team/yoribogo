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
//    @GetMapping("ex02")
//    public void ex02(@ModelAttribute("name") String name) {
//        log.info("ex02 ...............");
//        log.info(name);
//    }
//
//    //    나이 전달받기
//    @GetMapping("ex03")
//    public void ex03(@ModelAttribute("age") int age) {
//        log.info("ex03 ...............");
//        log.info("{}살", age);
//    }
//
//    @GetMapping("ex04")
//    public void ex04(String name, int age, Model model) {
//        log.info("ex04 ...............");
//        log.info("{}: {}살", name, age);
//        model.addAttribute("name", name);
//        model.addAttribute("age", age);
//    }
//
//    @GetMapping("ex05")
//    public String ex05(@RequestParam("job") String data, Model model) {
//        log.info("ex05 ...............");
//        log.info("직업: {}", data);
//        model.addAttribute("job", data);
//        return "ex05";
//    }
//}
