package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRangkingMapper {
    public List<PostVO> selectByRangking();
}
