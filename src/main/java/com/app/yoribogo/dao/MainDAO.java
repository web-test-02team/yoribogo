package com.app.yoribogo.dao;

import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MainDAO {
    public final MainMapper mainMapper;

//    주간 인기 요리보고
    public List<MemberVO> selectByWeeklyRecipe(){
        return mainMapper.select();
    }

//    Best Week

    public List<MemberVO> selectBestRecipe(){
        return mainMapper.selectBest();
    }

    //    오늘의 요리
    public Optional<MemberVO> selectTodayRecipe(){
        return mainMapper.selectToday();
    }

    //    새로운 요리를 만나보세요
    public List<MemberVO> selectNewCuisine(){
        return mainMapper.selectNewRecipe();
    }

    //    요리 분류
    public List<MemberVO> selectAllRecipes(){
        return mainMapper.selectAll();
    }
}
