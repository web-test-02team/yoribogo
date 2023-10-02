package com.app.yoribogo.service;

import com.app.yoribogo.dao.PostDAO;
import com.app.yoribogo.domain.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl implements PostService{
    private final PostDAO postDAO;

    @Override
    public List<PostVO> getByReview(){
        return postDAO.post();
    }
}
