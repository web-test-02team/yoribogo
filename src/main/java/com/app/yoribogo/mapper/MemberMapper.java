package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    //회원가입
    public void insert(MemberVO memberVO);
    //로그인
    public Optional<MemberVO> selectByLogin(MemberVO memberVO);
}
