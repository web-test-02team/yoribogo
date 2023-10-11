package com.app.yoribogo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyRecipeDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private String postDate;
    private Long postHits;
    private Long postLikeCount;
    private Long postCommentCount;
    private String memberId;
    private String categoryCName;
    private String categoryBName;
    private String categoryAName;
    private boolean postStatus;
}
