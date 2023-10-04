package com.app.yoribogo.service;

import com.app.yoribogo.dao.MainDAO;
import com.app.yoribogo.domain.PostDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MainServiceImpl implements MainService {

    private final MainDAO mainDAO;
    @Override
    public List<PostDTO> showByWeeklyRecipe() {
        return mainDAO.selectByWeeklyRecipe();
    }

    @Override
    public List<PostDTO> showBestRecipe() {
        return mainDAO.selectBestRecipe();
    }

    @Override
    public Optional<PostDTO> showTodayRecipe() {
        return mainDAO.selectTodayRecipe();
    }

    @Override
    public List<PostDTO> showNewRecipes() {
        return mainDAO.selectNewCuisine();
    }

    @Override
    public List<PostDTO> showAllRecipes() {
        return mainDAO.selectAllRecipes();
    }

    @Override
    public List<PostDTO> searchRecipes() { return mainDAO.lookUpRecipes(); }
}
