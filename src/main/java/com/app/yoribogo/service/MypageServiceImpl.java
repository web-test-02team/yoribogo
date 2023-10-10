package com.app.yoribogo.service;

import com.app.yoribogo.dao.MypageDAO;
import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.domain.Pagination;
import com.app.yoribogo.domain.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
    private final MypageDAO mypageDAO;

    @Override
    public void myinfoModify(MemberVO memberVO) { mypageDAO.save(memberVO); }

    @Override
    public void findByMemberIDForRecipe(Pagination pagination, Search search, Long id) {
        mypageDAO.findRecipe(pagination, search, id);
    }
}
