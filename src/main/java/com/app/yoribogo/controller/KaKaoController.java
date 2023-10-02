package com.app.yoribogo.controller;

import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.service.KaKaoService;
import com.app.yoribogo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/*
* 1. 일반 회원가입 진행
* 2. 일반 로그인
* 3. 카카오 연동하기
* 4. 로그아웃
* 5. 일반 로그인 또는 카카오 로그인 시 동일한 회원으로 로그인
*
* 1. 일반 회원가입 진행
* 2. 일반 로그인
* 3. 로그아웃
* 4. 카카오 로그인
* 5. 현재 계정이 2개인 상태
* 6. 로그아웃
* 7. 일반 로그인
* 8. 카카오 연동하기
* 9. 로그아웃
* 10. 일반 로그인 또는 카카오 로그인 시 동일한 회원으로 로그인
*
* 1. 카카오 로그인
* 2. 로그아웃
* 3. 일반 회원 가입 진행
* 4. 일반 로그인
* 5. 카카오 연동하기
* 6. 로그아웃
* 7. 일반 로그인 또는 카카오 로그인 시 동일한 회원으로 로그인
*
*
* 결론: 연동 후 카카오 또는 일반 로그인 시 하나의 계정(통합 계정)으로 이용 가능
* 
* */


@Controller
@RequiredArgsConstructor
@Slf4j
public class KaKaoController {
    private final KaKaoService kaKaoService;
    private final MemberService memberService;

    @GetMapping("/kakao/login")
    public RedirectView login(String code, HttpSession session){
        Long id = null;
        String token = kaKaoService.getKaKaoAccessToken(code);
        Optional<MemberVO> foundInfo = kaKaoService.getKaKaoInfo(token);
        if(foundInfo.isPresent()){
            if(session.getAttribute("member") != null) {
                id = ((MemberVO) session.getAttribute("member")).getId();
                log.info("ㅎㅎ");
            }
            memberService.join(foundInfo.get(), null, id);
            log.info("id:{}",id);
            MemberVO memberVO = memberService.getKaKaoMember(foundInfo.get().getMemberKakaoEmail()).get();
            session.setAttribute("member", memberVO);
            return new RedirectView("/");
        }
        return new RedirectView("/member/login");
    }
}
