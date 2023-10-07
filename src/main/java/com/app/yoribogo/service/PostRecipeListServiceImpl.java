package com.app.yoribogo.service;

import com.app.yoribogo.dao.PostRecipeListDAO;
import com.app.yoribogo.domain.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostRecipeListServiceImpl implements PostRecipeListService {

    private final PostRecipeListDAO postRecipeListDAO;

    @Override
    public List<PostDTO> getByRecipeListFree() {
        return  postRecipeListDAO.postRecipeListFree();
    }

    @Override
    public List<PostDTO> getByRecipeList() {

        return postRecipeListDAO.postRecipeList();
    }

}
