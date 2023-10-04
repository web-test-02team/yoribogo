package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MainMapper {
//    주간 인기 요리보고
    public List<PostDTO> select();

//    Best Week

    public List<PostDTO> selectBest();

//    오늘의 요리
    public Optional<PostDTO> selectToday();

//    새로운 요리를 만나보세요
    public List<PostDTO> selectNewRecipe();

//    요리 분류
    public List<PostDTO> selectAll();
}
