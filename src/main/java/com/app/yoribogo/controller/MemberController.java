package com.app.yoribogo.controller;



import com.app.yoribogo.domain.MemberDTO;
import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.service.EmailService;
import com.app.yoribogo.service.MemberService;
import com.app.yoribogo.service.TokenManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final EmailService emailService;

    //회원가입
    @GetMapping("join")
    public void goToEmailJoin(MemberVO memberVO) {
        ;
    }

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO, RedirectAttributes redirectAttributes) {
        memberService.join(memberVO, redirectAttributes, null);

        // 중복된 이메일이 없는 경우에만 joinComplete로 리다이렉트
        if (redirectAttributes.getFlashAttributes().containsKey("login")) {
            return new RedirectView("/member/join");
        } else {
            return new RedirectView("/member/joinComplete");
        }
    }

    //로그인
    @GetMapping("login")
    public void goToLoginMain(MemberVO memberVO) {
        ;
    }

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, HttpSession session, RedirectAttributes redirectAttributes) {
        Optional<MemberVO> foundMember = memberService.login(memberVO);
        Optional<MemberVO> foundEmail = memberService.searchEmail(memberVO);
        if (foundMember.isPresent()) {
            session.setAttribute("member", foundMember.get());
            return new RedirectView("/");
        } else {
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
    public void goToFindPassword() {
        ;
    }

    @PostMapping("findPassword")
    public RedirectView findEmail(MemberVO memberVO, RedirectAttributes redirectAttributes) {
        Optional<MemberVO> foundEmail = memberService.searchEmail(memberVO);
        if (foundEmail.isPresent()) {
            redirectAttributes.addFlashAttribute("foundEmail", foundEmail.get().getMemberEmail());
            redirectAttributes.addFlashAttribute("foundName", foundEmail.get().getMemberName());
            return new RedirectView("/member/findPasswordEmail");
        }
        redirectAttributes.addFlashAttribute("email", false);
        return new RedirectView("/member/findPassword");
    }

    @GetMapping("findPasswordEmail")
    public void gotoFindPasswordEmail(@ModelAttribute("foundEmail") String foundEmail, @ModelAttribute("foundName") String memberName) {
        emailService.sendPasswordResetEmail(foundEmail, memberName);
    }

    @GetMapping("findPasswordSend")
    public void goToFindPasswordSend(HttpServletRequest request, @RequestParam(name = "token", required = false) String token) {
        String foundEmail = TokenManager.getEmailFromToken(token); // 토큰을 사용하여 이메일을 찾음
        HttpSession session = request.getSession();
        session.setAttribute("foundEmail", foundEmail);
    }

    @PostMapping("findPasswordSend")
    public RedirectView changePassword(HttpServletRequest request, @RequestParam(name = "newPassword") String newPassword) {
        HttpSession session = request.getSession();
        String memberEmail = (String) session.getAttribute("foundEmail");
        // 이메일을 사용하여 사용자를 검색하고, 새로운 비밀번호로 업데이트
        memberService.change(memberEmail, newPassword);

        // 비밀번호 변경이 성공한 경우 로그인 페이지로 리다이렉트
        return new RedirectView("/member/login");
    }

    @GetMapping("joinComplete")
    public void goToJoinComplete() {
        ;
    }

    @GetMapping("mainPost")
    public String gotoPos(HttpServletRequest request, Model model) {
        Long id = (Long) request.getSession().getAttribute("id");
        return commonLogic2(id, model);
    }
    @PostMapping("mainPost")
    public String goToPost(HttpServletRequest request,@RequestParam("id") Long id, Model model) {
        request.getSession().setAttribute("id", id);
        return commonLogic2(id, model);
    }
    @PutMapping("/like")
    @ResponseBody
    public void toggleLike(@RequestParam("postId") Long postId) {

    }

    @GetMapping("introMain")
    public String goToIntro(HttpServletRequest request, Model model) {
        Long id = (Long) request.getSession().getAttribute("id");
        return commonLogic(id, model);
    }

    @PostMapping("introMain")
    public String goToIntroMain(HttpServletRequest request,@RequestParam("id") Long id, Model model) {
        request.getSession().setAttribute("id", id);
        return commonLogic(id, model);
    }

    //중복 메소드로 모아놈 잘못만들긴했는데 일단..
    private String commonLogic(Long id, Model model) {
            List<MemberDTO> foundMember = memberService.findByMember(id);
            Optional<MemberVO> foundId = memberService.selectById(id);
            List<String> daysAgo = new ArrayList<>();
            for (MemberDTO postList : foundMember) {
//       // postDTO.postDate를 LocalDateTime으로 변환
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime postDateTime = LocalDateTime.parse(postList.getPostDate(), formatter);

                // 현재 시간 가져오기
                LocalDateTime currentDateTime = LocalDateTime.now();

                // 두 날짜 사이의 차이 계산
                Duration duration = Duration.between(postDateTime, currentDateTime);

                // "n일전" 형식으로 포맷팅
                String dayAgo = duration.toDays() + "일전";

                // 계산한 값을 daysAgo 리스트에 추가
                daysAgo.add(dayAgo);
            }
        foundId.ifPresent(member -> model.addAttribute("foundId", member));
            model.addAttribute("memberId", foundMember);
            model.addAttribute("daysAgo", daysAgo);
            return "member/introMain";
        }

    private String commonLogic2(Long id, Model model) {
        List<MemberDTO> foundPost = memberService.findByMember(id);
        List<MemberDTO> foundMember = memberService.findByMember(id);
        Optional<MemberVO> foundId = memberService.selectById(id);
        List<String> daysAgo = new ArrayList<>();
        for (MemberDTO postList : foundPost) {
//       // postDTO.postDate를 LocalDateTime으로 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime postDateTime = LocalDateTime.parse(postList.getPostDate(), formatter);

            // 현재 시간 가져오기
            LocalDateTime currentDateTime = LocalDateTime.now();

            // 두 날짜 사이의 차이 계산
            Duration duration = Duration.between(postDateTime, currentDateTime);

            // "n일전" 형식으로 포맷팅
            String dayAgo = duration.toDays() + "일전";

            // 계산한 값을 daysAgo 리스트에 추가
            daysAgo.add(dayAgo);
        }
        foundId.ifPresent(member -> model.addAttribute("foundId", member));
        model.addAttribute("memberId",foundMember);
        model.addAttribute("id",foundPost);
        model.addAttribute("daysAgo",daysAgo);
        return "member/mainPost";
        }


    //    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        if(session!=null) {
            session.invalidate();
        }
        return new RedirectView("/");
    }

}