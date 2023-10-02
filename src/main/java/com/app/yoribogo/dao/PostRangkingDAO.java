package com.app.yoribogo.dao;

import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.domain.PostVO;
import com.app.yoribogo.mapper.PostRangkingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRangkingDAO {

    private final PostRangkingMapper postRangkingMapper;

     public List<PostDTO> postRangking(){

        return postRangkingMapper.selectByRangking();
    }

}
