package com.app.yoribogo.dao;


import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.domain.PostVO;
import com.app.yoribogo.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    // 무료리뷰글 목록
    public List<PostDTO> selectFree() {
        return postMapper.selectByFreeReviewList();
    }
    // 유료리뷰글 목록
    public List<PostDTO> selectPaid(){
        return  postMapper.selectByPaidReviewList();
    }


}
