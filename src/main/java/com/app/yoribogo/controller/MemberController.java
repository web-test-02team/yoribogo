package com.app.yoribogo.controller;


import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
    private final MemberService memberService;
    //회원가입
    @GetMapping("join")
    public void goToEmailJoin(MemberVO memberVO) {;}
    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        memberService.join(memberVO);
        return new RedirectView("/member/joinComplete");
    }
    //로그인
    @GetMapping("login")
    public void goToLoginMain(MemberVO memberVO) {;}

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, HttpSession session, RedirectAttributes redirectAttributes) {
        Optional<MemberVO> foundMember = memberService.login(memberVO);
        if (foundMember.isPresent()) {
            session.setAttribute("member", foundMember.get());
            return new RedirectView("/");
        }
        redirectAttributes.addFlashAttribute("login",false);
        return new RedirectView("/member/login");
    }

    @GetMapping("findPassword")
    public void goToFindPassword() {;}

    @GetMapping("findPasswordSend")
    public void goToFindPasswordSend() {;}

    @GetMapping("joinComplete")
    public void goToJoinComplete() {;}

    @GetMapping("mainPost")
    public void goToPost(){;}

    @GetMapping("introMain")
    public void goToIntroMain() {;}
}