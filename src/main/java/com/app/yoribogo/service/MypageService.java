package com.app.yoribogo.service;

import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.domain.Pagination;
import com.app.yoribogo.domain.Search;
import org.apache.ibatis.annotations.Param;

public interface MypageService {
    //    프로필 이미지, 배경 변경
    public void myinfoModify(MemberVO memberVO);

    //    내가 작성한 레시피 목록 조회
    public void findByMemberIDForRecipe(@Param("pagination") Pagination pagination, @Param("search") Search search, Long id);
}
