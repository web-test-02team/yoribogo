package com.app.yoribogo.controller;


import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/*")
public class PostController {

    private final PostService postService;

    @GetMapping(value = "read")
    public void goToRead() {
        ;
    }

    @GetMapping("write")
    public void goToWrite() {
        ;
    }

    @GetMapping("reviewlist")

    public void goToReviewList(Model model) {

        // 무료 리뷰 리스트
        List<PostDTO> freePosts = postService.getByFreeReview();
        List<String> limitPostContents = new ArrayList<>();
        List<String> daysAgo = new ArrayList<>();

        for (PostDTO freepost : freePosts) {
            String postContent = freepost.getPostContent();
            // 글 내용 30자 제한
            String limitPostContent = postContent.length() > 30 ? postContent.substring(0, 30) : postContent;
            limitPostContents.add(limitPostContent);

            //postDTO.postDate를 LocalDateTime으로 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime postDateTime = LocalDateTime.parse(freepost.getPostDate(), formatter);
            // 현재 시간 가져오기
            LocalDateTime currentDateTime = LocalDateTime.now();
            // 두 날짜 사이의 차이 계산
            Duration duration = Duration.between(postDateTime, currentDateTime);
            // "n일전" 형식으로 포맷팅
            String dayAgo = duration.toDays() + "일전";
            // 계산한 값을 daysAgo 리스트에 추가
            daysAgo.add(dayAgo);

    }



        // 유료 리뷰 리스트
        List<PostDTO> paidPosts = postService.getByPaidReview();

        for (PostDTO paidpost : paidPosts) {
            String postContent = paidpost.getPostContent();
            // 글 내용 30자 제한
            String limitPostContent = postContent.length() > 30 ? postContent.substring(0, 30) : postContent;
            limitPostContents.add(limitPostContent);

            //postDTO.postDate를 LocalDateTime으로 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime postDateTime = LocalDateTime.parse(paidpost.getPostDate(), formatter);
            // 현재 시간 가져오기
            LocalDateTime currentDateTime = LocalDateTime.now();
            // 두 날짜 사이의 차이 계산
            Duration duration = Duration.between(postDateTime, currentDateTime);
            // "n일전" 형식으로 포맷팅
            String dayAgo = duration.toDays() + "일전";
            // 계산한 값을 daysAgo 리스트에 추가
            daysAgo.add(dayAgo);
        }
        model.addAttribute("freePosts", freePosts);
        model.addAttribute("paidPosts", paidPosts);
        model.addAttribute("daysAgo", daysAgo);
        model.addAttribute("limitPostContents", limitPostContents);
    }
}

