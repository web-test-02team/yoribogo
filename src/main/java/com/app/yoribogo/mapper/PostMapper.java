package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    // 무료리뷰글 목록
    public List<PostDTO> selectByFreeReviewList();

    // 유료리뷰글 목록
    public List<PostDTO> selectByPaidReviewList();
}
