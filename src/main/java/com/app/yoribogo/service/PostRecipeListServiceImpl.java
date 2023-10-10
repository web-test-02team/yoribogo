package com.app.yoribogo.service;

import com.app.yoribogo.dao.PostRecipeListDAO;
import com.app.yoribogo.domain.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostRecipeListServiceImpl implements PostRecipeListService {

    private final PostRecipeListDAO postRecipeListDAO;

    @Override
    public List<PostDTO> getByFreeRecipeList() {

        return  postRecipeListDAO.postFreeRecipeList();
    }

    @Override
    public List<PostDTO> getByPaidRecipeList() {

        return postRecipeListDAO.postPaidRecipeList();
    }

}
