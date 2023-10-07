package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.MemberDTO;
import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberMapperTest {
    @Autowired
    private  MemberMapper memberMapper;

    @Autowired
    private MemberService memberService;
    @Test
    public void insert(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("박세준");
        memberVO.setMemberLoginCode("YORIBOGO");
        memberMapper.insert(memberVO);
    }
    //로그인
    @Test
    public void selectTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.selectByLogin(memberVO).map(MemberVO::toString).ifPresent(log::info);
    }
    @Test
    public void selectId() {
        memberMapper.selectIdJoin(61L).map(MemberVO::toString).ifPresent(log::info);
    }

}
