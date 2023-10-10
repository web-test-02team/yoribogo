package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    // 리뷰글 목록
    public List<PostDTO> selectByReviewList();
    // 조회수 증가
    public void updatePostHits(int postId);
}
