package com.app.yoribogo.controller;

import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.domain.PostVO;
import com.app.yoribogo.mapper.PostRangkingMapper;
import com.app.yoribogo.service.PostRangkingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/rangking/*")
public class PostRangkingController {

    private final PostRangkingService postRangkingService;

    @GetMapping("rangking")
    public void goToRangking(Model model){

        List<PostDTO> posts = postRangkingService.getByRangking();
        model.addAttribute("posts", posts);

    }
}
