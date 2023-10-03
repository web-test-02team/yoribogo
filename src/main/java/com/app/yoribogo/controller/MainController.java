package com.app.yoribogo.controller;

import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final MainService mainService;
    @GetMapping("/")
    public String goToMain(Model model){

    //    주간 인기 요리보고
    List<MemberVO> weeklyRecipes = mainService.showByWeeklyRecipe();
    model.addAttribute("weeklyRecipes", weeklyRecipes);

    //    Best Week
    List<MemberVO> bestRecipes = mainService.showBestRecipe();
    model.addAttribute("bestRecipes", bestRecipes);

    //    오늘의 요리
    Optional<MemberVO> todayRecipe = mainService.showTodayRecipe();
    model.addAttribute("todayRecipe", todayRecipe);

    //    새로운 요리를 만나보세요
    List<MemberVO> newRecipes = mainService.showNewRecipes();
    model.addAttribute("newRecipes", newRecipes);

    //    요리 분류
    List<MemberVO> allRecipes = mainService.showAllRecipes();
    model.addAttribute("allRecipes", allRecipes);


        return "main";
    }

}
