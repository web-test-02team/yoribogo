package com.app.yoribogo.dao;

import com.app.yoribogo.domain.PostDTO;
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
    public List<PostDTO> selectByWeeklyRecipe(){
        return mainMapper.select();
    }

//    Best Week

    public List<PostDTO> selectBestRecipe(){
        return mainMapper.selectBest();
    }

    //    오늘의 요리
    public Optional<PostDTO> selectTodayRecipe(){
        return mainMapper.selectToday();
    }

    //    새로운 요리를 만나보세요
    public List<PostDTO> selectNewCuisine(){
        return mainMapper.selectNewRecipe();
    }

    //    요리 분류
    public List<PostDTO> selectAllRecipes(){
        return mainMapper.selectAll();
    }

    //    인기검색어
    public List<PostDTO> lookUpRecipes() { return mainMapper.lookUp();}
}
