package com.app.yoribogo.service;

import com.app.yoribogo.dao.PostDAO;
import com.app.yoribogo.domain.PostDTO;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Override
    public List<PostDTO> getByFreeReview() {
        return postDAO.selectFree();
    }
    @Override
    public List<PostDTO> getByPaidReview(){
        return postDAO.selectPaid();
    }


}