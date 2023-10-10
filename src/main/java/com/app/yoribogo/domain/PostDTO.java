package com.app.yoribogo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private String postDate;
    private Long postHits;
    private Long postLikeCount;
    private Long postCommentCount;
    private String memberId;
    private String categoryCId;
    private String memberName;
    private String categoryCName;
    private String categoryBName;
    private String categoryAName;
    private String postFilePath;

}
