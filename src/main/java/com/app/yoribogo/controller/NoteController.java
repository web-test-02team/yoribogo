package com.app.yoribogo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/note/*")
public class NoteController {

    @GetMapping("inbox")
    public void goToInbox(){;}

    @GetMapping("message")
    public void goToMessage(){;}

    @GetMapping("note")
    public void goToNote(){;}

}

