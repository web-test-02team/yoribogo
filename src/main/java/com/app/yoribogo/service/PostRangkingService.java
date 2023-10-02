package com.app.yoribogo.service;

import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.domain.PostVO;

import java.util.List;

public interface PostRangkingService {
    public List<PostDTO> getByRangking();
}
