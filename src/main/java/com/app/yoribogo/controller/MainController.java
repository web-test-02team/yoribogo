package com.app.yoribogo.controller;

import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    List<PostDTO> weeklyRecipes = mainService.showByWeeklyRecipe();
    model.addAttribute("weeklyRecipes", weeklyRecipes);

    //    Best Week
    List<PostDTO> bestRecipes = mainService.showBestRecipe();
    List<String> truncatedPostContents = new ArrayList<>();
    List<String> daysAgo = new ArrayList<>();

    for (PostDTO recipe : bestRecipes) {
        String postContent = recipe.getPostContent();

        // 글 내용을 30자로 제한
        String truncatedPostContent = postContent.length() > 30 ? postContent.substring(0, 30) : postContent;

        truncatedPostContents.add(truncatedPostContent);
//
//       // postDTO.postDate를 LocalDateTime으로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime postDateTime = LocalDateTime.parse(recipe.getPostDate(), formatter);

        // 현재 시간 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 두 날짜 사이의 차이 계산
        Duration duration = Duration.between(postDateTime, currentDateTime);

        // "n일전" 형식으로 포맷팅
        String dayAgo = duration.toDays() + "일전";

        // 계산한 값을 daysAgo 리스트에 추가
        daysAgo.add(dayAgo);
    }


    model.addAttribute("truncatedPostContents", truncatedPostContents);

    model.addAttribute("daysAgo", daysAgo);


    model.addAttribute("bestRecipes", bestRecipes);



    //    오늘의 요리

    Optional<PostDTO> todayRecipe = mainService.showTodayRecipe();

    if (todayRecipe.isPresent()) {
        String truncatedTodayRecipeTitle = "";
        String truncatedTodayRecipeContent = "";

        String todayRecipeContent = todayRecipe.get().getPostContent();
        String todayRecipeTitle = todayRecipe.get().getPostTitle();

        // 제목에서 '레시피' 단어 제거
        if (todayRecipeTitle.contains("레시피")) {
            truncatedTodayRecipeTitle = todayRecipeTitle.replace("레시피", "");
        } else {
            truncatedTodayRecipeTitle = todayRecipeTitle;
        }

        // 내용을 30자로 자르기
        truncatedTodayRecipeContent = todayRecipeContent.length() > 30 ? todayRecipeContent.substring(0, 30) : todayRecipeContent;

        model.addAttribute("todayRecipe", todayRecipe.get());
        model.addAttribute("truncatedTodayRecipeTitle", truncatedTodayRecipeTitle);
        model.addAttribute("truncatedTodayRecipeContent", truncatedTodayRecipeContent);
    }

//    //    새로운 요리를 만나보세요
    List<PostDTO> newRecipes = mainService.showNewRecipes();
    model.addAttribute("newRecipes", newRecipes);

//    //    요리 분류
    List<PostDTO> allRecipes = mainService.showAllRecipes();
    model.addAttribute("allRecipes", allRecipes);

//    인기 검색어
//
   List<PostDTO> searchedRecipes =  mainService.searchRecipes();
   model.addAttribute("searchedRecipes", searchedRecipes);


        return "main";
    }

}
