package com.app.yoribogo.dao;

import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.domain.MyRecipeDTO;
import com.app.yoribogo.domain.*;
import com.app.yoribogo.mapper.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MypageDAO {
    private final MypageMapper mypageMapper;


//    프로필 이미지, 배경 변경
    public void save(MemberVO memberVO){mypageMapper.update(memberVO);}

    //    내가 작성한 레시피 목록 조회
    public List<MyRecipeDTO> findRecipe(@Param("pagination") Pagination pagination, @Param("search") Search search, Long id){
        return mypageMapper.selectAll(pagination, search, id);}

    //    내가 작성한 레시피 전체 개수
    public int findTotal(Long id){return mypageMapper.selectTotal(id);}
}