package com.app.yoribogo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class PostVO implements Serializable {
    private Long id;
    private String postTitle;
    private String postContent;
    private String postDate;
    private Long postHits;
    private Long postLikeCount;
    private Long postCommentCount;
    private String memberId;
    private String categoryCId;
}
