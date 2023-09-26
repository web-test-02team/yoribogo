package com.app.yoribogo.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class CommentVO implements Serializable {
    private Long id;
    private String commentWriteDate;
    private String commentRewriteDate;
    private String commentLikeCount;
    private String commentContent;
    private Long postId;
    private Long memberId;
}
