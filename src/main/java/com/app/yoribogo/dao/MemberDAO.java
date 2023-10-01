package com.app.yoribogo.dao;

import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    public void save(MemberVO memberVO) {

        memberMapper.insert(memberVO);
    }
    public Optional<MemberVO> login(MemberVO memberVO){

        return memberMapper.selectByLogin(memberVO);
    }
}
