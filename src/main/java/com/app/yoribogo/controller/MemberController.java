package com.app.yoribogo.controller;


import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public RedirectView join(MemberVO memberVO,RedirectAttributes redirectAttributes){
        memberService.join(memberVO, redirectAttributes);

        // 중복된 이메일이 없는 경우에만 joinComplete로 리다이렉트
        if (redirectAttributes.getFlashAttributes().containsKey("login")) {
            return new RedirectView("/member/join");
        } else {
            return new RedirectView("/member/joinComplete");
        }
    }
    //로그인
    @GetMapping("login")
    public void goToLoginMain(MemberVO memberVO) {;}

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, HttpSession session, RedirectAttributes redirectAttributes) {
        Optional<MemberVO> foundMember = memberService.login(memberVO);
        Optional<MemberVO> foundEmail=memberService.searchEmail(memberVO);
        if (foundMember.isPresent()) {
            session.setAttribute("member", foundMember.get());
            return new RedirectView("/");
        }
        else {
            // 로그인 실패
            if (foundEmail.isPresent()) {
                // 이메일은 존재하지만 비밀번호가 틀린 경우
                redirectAttributes.addFlashAttribute("loginPassword", "false");
            } else {
                // 가입된 이메일 계정이 아닌 경우
                redirectAttributes.addFlashAttribute("loginEmail", "false");
            }
            return new RedirectView("/member/login");
        }
    }
    @GetMapping("findPassword")
    public void goToFindPassword() {;}
    @PostMapping("findPassword")
    public RedirectView findEmail(MemberVO memberVO,RedirectAttributes redirectAttributes){
        Optional<MemberVO> foundEmail=memberService.searchEmail(memberVO);
        if(foundEmail.isPresent()){
            redirectAttributes.addFlashAttribute("foundEmail", foundEmail.get().getMemberEmail());
            return new RedirectView("/member/findPasswordSend");
        }
        redirectAttributes.addFlashAttribute("email",false);
        return new RedirectView("/member/findPassword");
    }
    @GetMapping("findPasswordSend")
    public void goToFindPasswordSend() {;}
    @PostMapping("findPasswordSend")
    public RedirectView changePassword(@ModelAttribute("foundEmail") String memberEmail, @RequestParam("newPassword") String memberPassword) {
        // 이메일을 사용하여 사용자를 검색하고, 새로운 비밀번호로 업데이트
        memberService.change(memberEmail, memberPassword);

        // 비밀번호 변경이 성공한 경우 로그인 페이지로 리다이렉트
        return new RedirectView("/member/login");
    }
    @GetMapping("joinComplete")
    public void goToJoinComplete() {;}

    @GetMapping("mainPost")
    public void goToPost(){;}

    @GetMapping("introMain")
    public void goToIntroMain() {;}
}