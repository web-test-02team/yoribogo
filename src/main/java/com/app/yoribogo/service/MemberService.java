package com.app.yoribogo.service;

import com.app.yoribogo.domain.MemberVO;

import java.util.Optional;

public interface MemberService {
    //회원가입
    public void join(MemberVO memberVO);

    public Optional<MemberVO> login(MemberVO memberVO);
}
