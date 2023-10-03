package com.app.yoribogo.service;

import com.app.yoribogo.domain.MemberVO;

import java.util.List;
import java.util.Optional;

public interface MainService {
    //    주간 인기 요리보고
    public List<MemberVO> showByWeeklyRecipe();

    //    Best Week

    public List<MemberVO> showBestRecipe();

    //    오늘의 요리
    public Optional<MemberVO> showTodayRecipe();

    //    새로운 요리를 만나보세요
    public List<MemberVO> showNewRecipes();

    //    요리 분류
    public List<MemberVO> showAllRecipes();
}
