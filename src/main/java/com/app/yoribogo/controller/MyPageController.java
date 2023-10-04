package com.app.yoribogo.controller;

import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
@Slf4j
@SessionAttributes("member")
public class MyPageController {
    private final MypageService mypageService;

    @GetMapping("mycomment")
    public  void goToMyComment(){;}

    @GetMapping("myfavorite")
    public void goToMyFavorite(){;}

    @GetMapping("myinfo")
    public void goToMyInfo(){;}

    @PostMapping("myinfo")
    public RedirectView updateProfile(@SessionAttribute("member") Optional<MemberVO> member,@RequestParam("uuid") List<String> uuids, @RequestParam("uploadFile") List<MultipartFile> uploadFiles){
        int count = 0;
        for(int i=0; i<uploadFiles.size(); i++){
            if(uploadFiles.get(i).isEmpty()) {count++; continue;}
            int index1 = i - count;
            int index2 = i;
            int finalCount = count;
            member.ifPresent(memberVO -> {
                memberVO.setMemberProfileName(uuids.get(index1) + "_" + uploadFiles.get(index2).getOriginalFilename());
                memberVO.setMemberProfilePath(getPath());

                mypageService.imageModify(memberVO);
            });
        }
        return new RedirectView("/mypage/myinfo");
    }

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
