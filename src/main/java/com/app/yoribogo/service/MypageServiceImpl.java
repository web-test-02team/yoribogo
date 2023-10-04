package com.app.yoribogo.service;

import com.app.yoribogo.dao.MypageDAO;
import com.app.yoribogo.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
    private final MypageDAO mypageDAO;

    @Override
    public void imageModify(MemberVO memberVO) { mypageDAO.save(memberVO); }
}
