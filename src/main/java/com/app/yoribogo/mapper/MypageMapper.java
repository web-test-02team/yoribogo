package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MypageMapper {
//     내 정보 수정
    public void update(MemberVO memberVO);

//    내가 작성한 레시피 목록 조회
    public void selectAll(@Param("pagination") Pagination pagination, @Param("search") Search search, Long id);

//    내가 작성한 레시피 전체 개수
    public int selectTotal(Long id);
}
