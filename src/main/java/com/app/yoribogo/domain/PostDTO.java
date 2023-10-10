package com.app.yoribogo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@ApiModel(value = "게시글 목록")
public class PostDTO {
    @ApiModelProperty(value = "게시글 번호", example = "88", required = true)
    private Long id;
    @ApiModelProperty(value = "게시글 제목", example = "오꼬노미야끼", required = true)
    private String postTitle;
    @ApiModelProperty(value = "게시글 내용", example = "저희 일식 점문점인데 스시나 회보다", required = true)
    private String postContent;
    @ApiModelProperty(value = "게시글 날짜", example = "2023-10-07", required = true)
    private String postDate;
    @ApiModelProperty(value = "조회수", example = "121")
    private Long postHits;
    @ApiModelProperty(value = "좋아요 수", example = "115")
    private Long postLikeCount;
    @ApiModelProperty(value = "댓글 수", example = "100")
    private Long postCommentCount;
    @ApiModelProperty(value = "회원번호", example = "108", required = true)
    private String memberId;
    @ApiModelProperty(value = "카테고리C 번호", example = "23", required = true)
    private String categoryCId;
    @ApiModelProperty(value = "회원이름", example = "박세준")
    private String memberName;
    @ApiModelProperty(value = "카테고리C 이름", example = "일식", required = true)
    private String categoryCName;
    @ApiModelProperty(value = "카테고리B 이름", example = "무료", required = true)
    private String categoryBName;
    private String categoryAName;
    private String postFilePath;

}
