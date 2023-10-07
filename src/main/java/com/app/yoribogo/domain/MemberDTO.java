package com.app.yoribogo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberDTO {
    private Long Id;
    private String memberName;
    private String memberBackgroundName;
    private String memberBackgroundPath;
    private String memberOneLineIntro;
    private String memberIntroduction;
    private String memberProfileName;
    private String memberProfilePath;
    private Long postId;
    private String postTitle;
    private String postContent;
    private String postDate;
    private Long postHits;
    private Long postLikeCount;
    private Long postCommentCount;
    private String postFileName;
    private String postFilePath;
    private String postFileUuid;
    private String categoryCName;
    private String categoryBName;
}
