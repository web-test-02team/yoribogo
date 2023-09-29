package com.app.yoribogo.service;

import com.app.yoribogo.dao.MemberDAO;
import com.app.yoribogo.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    @Override
    public void join(MemberVO memberVO){
        memberVO.setMemberLoginCode("YORIBOGO");
        memberDAO.save(memberVO);

    }

    @Override
    public Optional<MemberVO> login(MemberVO memberVO) {
        return memberDAO.login(memberVO);
    }
}
