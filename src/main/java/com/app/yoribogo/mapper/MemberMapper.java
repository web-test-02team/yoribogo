package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    //일반 회원가입
    public void insert(MemberVO memberVO);
    //로그인
    public Optional<MemberVO> selectByLogin(MemberVO memberVO);
    // 이메일 찾기
    public Optional<MemberVO> selectByEmail(MemberVO memberVO);
    //비밀번호 변경
    public void update(@Param("memberEmail") String memberEmail, @Param("memberPassword") String memberPassword);
}
