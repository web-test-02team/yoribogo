package com.app.yoribogo.controller;


import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.service.PostService;
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
@RequestMapping("/post/*")
public class PostController {
   private final PostService postService;
    @GetMapping("read")
    public void goToRead() {;}

    @GetMapping("write")
    public void goToWrite() {;}

    @GetMapping("recipelist")
    public void goToRecipeList() {;}

    @GetMapping("reviewlist")

    public void goToReviewList(Model model) {

        List<PostDTO> posts=postService.getByReview();
        model.addAttribute("posts",posts);

        }


}

