package com.app.yoribogo.service;

import com.app.yoribogo.domain.PostDTO;

import java.util.List;

public interface PostRecipeListService {
    public List<PostDTO> getByRecipeListFree();


    public List<PostDTO> getByRecipeList();
}