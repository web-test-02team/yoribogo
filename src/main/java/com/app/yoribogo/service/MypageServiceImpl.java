package com.app.yoribogo.service;

import com.app.yoribogo.dao.MypageDAO;
import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.domain.MyRecipeDTO;
import com.app.yoribogo.domain.Pagination;
import com.app.yoribogo.domain.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
    private final MypageDAO mypageDAO;

    @Override
    public void myinfoModify(MemberVO memberVO) { mypageDAO.save(memberVO); }

    @Override
    public List<MyRecipeDTO> getByMemberIdForRecipe(Pagination pagination, Search search, Long id) {
        //  내가 작성한 레시피 목록
        final List<MyRecipeDTO> myRecipes = mypageDAO.findRecipe(pagination, search, id);
        return myRecipes;
    }

    @Override
    public int getByMemberIdTotal(Long id) {
        return mypageDAO.findTotal(id);
    }
}
