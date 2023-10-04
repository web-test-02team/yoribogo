package com.app.yoribogo.dao;


import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.domain.PostVO;
import com.app.yoribogo.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public List<PostDTO> post() {
        return postMapper.selectByReviewList();
    }
}
