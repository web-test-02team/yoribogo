package com.app.yoribogo.controller;

import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.domain.Pagination;
import com.app.yoribogo.domain.Search;
import com.app.yoribogo.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
@Slf4j
//@SessionAttributes("member")
public class MyPageController {
    private final MypageService mypageService;

    @GetMapping("mycomment")
    public  void goToMyComment(){;}

    @GetMapping("myfavorite")
    public void goToMyFavorite(){;}

    @GetMapping("myinfo")
    public void goToMyInfo(){;}

    @PostMapping("myinfo")
    public RedirectView updateProfile(HttpSession session, @RequestParam("myInformation") List<String> myInformations, @RequestParam("uuid") List<String> uuids, @RequestParam("uploadFile") List<MultipartFile> uploadFiles){
        MemberVO memberVO = ((MemberVO)session.getAttribute("member"));

        if(!uploadFiles.get(0).isEmpty() && !uploadFiles.get(1).isEmpty()) {
            memberVO.setMemberProfileName(uuids.get(0) + "_" + uploadFiles.get(0).getOriginalFilename());
            memberVO.setMemberProfilePath(getPath());
            memberVO.setMemberBackgroundName(uuids.get(1) + "_" + uploadFiles.get(1).getOriginalFilename());
            memberVO.setMemberBackgroundPath(getPath());
        }else if(!uploadFiles.get(0).isEmpty() && uploadFiles.get(1).isEmpty()){
            memberVO.setMemberProfileName(uuids.get(0) + "_" + uploadFiles.get(0).getOriginalFilename());
            memberVO.setMemberProfilePath(getPath());
        }else if(uploadFiles.get(0).isEmpty() && !uploadFiles.get(1).isEmpty()){
            memberVO.setMemberBackgroundName(uuids.get(1) + "_" + uploadFiles.get(1).getOriginalFilename());
            memberVO.setMemberBackgroundPath(getPath());
        }else{}

        memberVO.setMemberOneLineIntro(myInformations.get(0));
        memberVO.setMemberIntroduction(myInformations.get(1));
        memberVO.setMemberName(myInformations.get(2));

        mypageService.myinfoModify(memberVO);

        return new RedirectView("/mypage/myinfo");
    }

    @GetMapping("mypurchase")
    public void goToMyPurchase(){;}

    @GetMapping("myrecipe")
    public void goToMyRecipe(Pagination pagination, Search search, Model model){
        pagination.setTotal();
    }

    @GetMapping("myreview")
    public void goToMyReview(){;}

    @GetMapping("othersreview")
    public void goToOthersReview(){;}

    private String getPath() { return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));}
}
