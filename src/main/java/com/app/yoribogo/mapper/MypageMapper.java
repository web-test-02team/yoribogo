package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {
//    프로필 이미지, 배경 변경
    public void update(MemberVO memberVO);
}
