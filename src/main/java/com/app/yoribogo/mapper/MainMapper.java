package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MainMapper {
//    주간 인기 요리보고
    public List<MemberVO> select();

//    Best Week

    public List<MemberVO> selectBest();

//    오늘의 요리
    public Optional<MemberVO> selectToday();

//    새로운 요리를 만나보세요
    public List<MemberVO> selectNewRecipe();

//    요리 분류
    public List<MemberVO> selectAll();
}
