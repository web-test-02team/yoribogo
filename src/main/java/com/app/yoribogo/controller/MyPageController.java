package com.app.yoribogo.controller;

import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
        }else{

        }

        memberVO.setMemberOneLineIntro(myInformations.get(0));
        memberVO.setMemberIntroduction(myInformations.get(1));
        memberVO.setMemberName(myInformations.get(2));

        mypageService.myinfoModify(memberVO);

        return new RedirectView("/mypage/myinfo");
    }

//    @PostMapping("myinfo")
//    public RedirectView updateProfile(HttpSession session, @RequestParam("uuid") List<String> uuids, @RequestParam("uploadFile") List<MultipartFile> uploadFiles){
//        int count = 0;
//        for(int i=0; i<uploadFiles.size(); i++){
//            if(uploadFiles.get(i).isEmpty()) {count++; continue;}
//
//            MemberVO memberVO = ((MemberVO)session.getAttribute("member"));
//            memberVO.setMemberProfileName(uuids.get(i - count) + "_" + uploadFiles.get(i).getOriginalFilename());
//            memberVO.setMemberProfilePath(getPath());
//            memberVO.setMemberBackgroundName(uuids.get(i - count) + "_" + uploadFiles.get(i).getOriginalFilename());
//            memberVO.setMemberBackgroundPath(getPath());
//            mypageService.imageModify(memberVO);
//        }
//        return new RedirectView("/mypage/myinfo");
//    }

//    @PostMapping("myinfo")
//    public RedirectView updateProfile(HttpSession session, @RequestParam("myInformation") List<String> myInformations, @RequestParam("uuidProfile") String uuidProfile, @RequestParam("profileUpload") MultipartFile profileUpload, @RequestParam("uuidBackground") String uuidBackground, @RequestParam("backgroundUpload") MultipartFile backgroundUpload){
//        MemberVO memberVO = ((MemberVO)session.getAttribute("member"));
//        memberVO.setMemberOneLineIntro(myInformations.get(0));
//        memberVO.setMemberIntroduction(myInformations.get(1));
//        memberVO.setMemberName(myInformations.get(2));
//
//        if(!profileUpload.isEmpty() || !backgroundUpload.isEmpty()){
//            if(profileUpload.isEmpty()){
//                memberVO.setMemberBackgroundName(uuidBackground + "_" + backgroundUpload.getOriginalFilename());
//                memberVO.setMemberBackgroundPath(getPath());
//            }else if(backgroundUpload.isEmpty()){
//                memberVO.setMemberProfileName(uuidProfile + "_" + profileUpload.getOriginalFilename());
//                memberVO.setMemberProfilePath(getPath());
//            }else{
//                memberVO.setMemberProfileName(uuidProfile + "_" + profileUpload.getOriginalFilename());
//                memberVO.setMemberProfilePath(getPath());
//                memberVO.setMemberBackgroundName(uuidBackground + "_" + backgroundUpload.getOriginalFilename());
//                memberVO.setMemberBackgroundPath(getPath());
//            }
//        }
//
//        mypageService.myinfoModify(memberVO);
//
//        return new RedirectView("/mypage/myinfo");
//    }

//    @PostMapping("myinfo")
//    public RedirectView updateProfile(HttpSession session, @RequestParam("uuidProfile") String uuidProfile, @RequestParam("profileUpload") MultipartFile profileUpload, @RequestParam("uuidBackground") String uuidBackground, @RequestParam("backgroundUpload") MultipartFile backgroundUpload){
//        MemberVO memberVO = ((MemberVO)session.getAttribute("member"));
//
//        if(!profileUpload.isEmpty() || !backgroundUpload.isEmpty()){
//            if(profileUpload.isEmpty()){
//                memberVO.setMemberBackgroundName(uuidBackground + "_" + backgroundUpload.getOriginalFilename());
//                memberVO.setMemberBackgroundPath(getPath());
//            }else if(backgroundUpload.isEmpty()){
//                memberVO.setMemberProfileName(uuidProfile + "_" + profileUpload.getOriginalFilename());
//                memberVO.setMemberProfilePath(getPath());
//            }else{
//                memberVO.setMemberProfileName(uuidProfile + "_" + profileUpload.getOriginalFilename());
//                memberVO.setMemberProfilePath(getPath());
//                memberVO.setMemberBackgroundName(uuidBackground + "_" + backgroundUpload.getOriginalFilename());
//                memberVO.setMemberBackgroundPath(getPath());
//            }
//        }
//
//        mypageService.myinfoModify(memberVO);
//
//        return new RedirectView("/mypage/myinfo");
//    }

//    @PostMapping("myinfo-intro")
//    public RedirectView updateProfile(HttpSession session, @RequestParam("myInformation") List<String> myInformations){
//        MemberVO memberVO = ((MemberVO)session.getAttribute("member"));
//        memberVO.setMemberOneLineIntro(myInformations.get(0));
//        memberVO.setMemberIntroduction(myInformations.get(1));
//        memberVO.setMemberName(myInformations.get(2));
//
//        mypageService.myinfoModify(memberVO);
//
//        return new RedirectView("/mypage/myinfo");
//    }

    @GetMapping("mypurchase")
    public void goToMyPurchase(){;}

    @GetMapping("myrecipe")
    public void goToMyRecipe(){;}

    @GetMapping("myreview")
    public void goToMyReview(){;}

    @GetMapping("othersreview")
    public void goToOthersReview(){;}

    private String getPath() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
