package com.app.yoribogo.service;

import com.app.yoribogo.dao.MainDAO;
import com.app.yoribogo.domain.MemberVO;
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
    public List<MemberVO> showByWeeklyRecipe() {
        return mainDAO.selectByWeeklyRecipe();
    }

    @Override
    public List<MemberVO> showBestRecipe() {
        return mainDAO.selectBestRecipe();
    }

    @Override
    public Optional<MemberVO> showTodayRecipe() {
        return mainDAO.selectTodayRecipe();
    }

    @Override
    public List<MemberVO> showNewRecipes() {
        return mainDAO.selectNewCuisine();
    }

    @Override
    public List<MemberVO> showAllRecipes() {
        return mainDAO.selectAllRecipes();
    }
}
