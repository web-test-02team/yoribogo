package com.app.yoribogo.service;

import com.app.yoribogo.dao.MemberDAO;
import com.app.yoribogo.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    @Override
    public void join(MemberVO memberVO, RedirectAttributes redirectAttributes) {
        // 회원 가입 전에 중복된 이메일을 검사
        Optional<MemberVO> foundEmail = searchEmail(memberVO);
        if (foundEmail.isPresent()) {
            // 이메일이 중복되면 로그인 실패 메시지를 전달
            redirectAttributes.addFlashAttribute("login", false);
            return;
        }
        // 중복된 이메일이 없는 경우 회원 가입을 진행
        memberVO.setMemberLoginCode("YORIBOGO");
        memberDAO.save(memberVO);
    }

    @Override
    public Optional<MemberVO> login(MemberVO memberVO) {
        return memberDAO.login(memberVO);
    }

    @Override
    public Optional<MemberVO> searchEmail(MemberVO memberVO) {
        return memberDAO.searchEmail(memberVO);
    }

    @Override
    public void change(String memberEmail, String memberPassword) {
        memberDAO.change(memberEmail,memberPassword);
    }

}
