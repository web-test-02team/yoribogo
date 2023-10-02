package com.app.yoribogo.service;

import com.app.yoribogo.dao.PostRangkingDAO;
import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.domain.PostVO;
import com.app.yoribogo.mapper.PostRangkingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostRangkingServiceImpl implements PostRangkingService {

    private final PostRangkingDAO postRangkingDAO;

    @Override
    public List<PostDTO> getByRangking() {

        return postRangkingDAO.postRangking();
    }
}
