package com.app.yoribogo.controller;

import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.service.PostRecipeListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post/*")
@RequiredArgsConstructor
public class PostRecipeListController {

    private final PostRecipeListService postRecipeListService;

    @GetMapping("recipelist")
    public String getList(@RequestParam(required = false) String recipeListFree, Model model) {

        if("free".equals(recipeListFree) ) {
            List<PostDTO> recipes = postRecipeListService.getByRecipeListFree();

            model.addAttribute("recipes", recipes);
        } else {
            List<PostDTO>  recipes = postRecipeListService.getByRecipeList();
            model.addAttribute("recipes", recipes);
        }


        return "/post/recipelist";
    }
}
