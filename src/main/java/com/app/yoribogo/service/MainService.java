package com.app.yoribogo.service;

import com.app.yoribogo.domain.PostDTO;

import java.util.List;
import java.util.Optional;

public interface MainService {
    //    주간 인기 요리보고
    public List<PostDTO> showByWeeklyRecipe();

    //    Best Week

    public List<PostDTO> showBestRecipe();

    //    오늘의 요리
    public Optional<PostDTO> showTodayRecipe();

    //    새로운 요리를 만나보세요
    public List<PostDTO> showNewRecipes();

    //    요리 분류
    public List<PostDTO> showAllRecipes();
}
