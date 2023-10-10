package com.app.yoribogo.service;

import com.app.yoribogo.domain.PostDTO;

import java.util.List;

public interface PostRecipeListService {

    public List<PostDTO> getByFreeRecipeList();


    public List<PostDTO> getByPaidRecipeList();

}