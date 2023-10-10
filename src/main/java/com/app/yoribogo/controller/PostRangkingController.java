package com.app.yoribogo.controller;

import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.domain.PostVO;
import com.app.yoribogo.mapper.PostRangkingMapper;
import com.app.yoribogo.service.PostRangkingService;
import com.app.yoribogo.service.PostRecipeListService;
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
    private final PostRecipeListService postRecipeListService;

    @GetMapping("rangking")
    public void goToRangking(Model model){

        List<PostDTO> posts = postRangkingService.getByRangking();
        List<PostDTO> freeRecipes = postRecipeListService.getByFreeRecipeList();
        model.addAttribute("posts", posts);
        model.addAttribute("freeRecipes", freeRecipes);

    }

}
