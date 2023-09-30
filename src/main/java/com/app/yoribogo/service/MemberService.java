package com.app.yoribogo.service;

import com.app.yoribogo.domain.MemberVO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

public interface MemberService {
    //회원가입
    public void join(MemberVO memberVO , RedirectAttributes redirectAttributes);

    public Optional<MemberVO> login(MemberVO memberVO);
    public Optional<MemberVO> searchEmail(MemberVO memberVO);
    public void change(String memberEmail,String memberPassword);
}
