package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MypageMapperTest {
    @Autowired
    private MypageMapper mypageMapper;

    @Test
    public void updateTest(){
        MemberVO memberVO = new MemberVO();

        memberVO.setId(66L);
        memberVO.setMemberProfileName("");
        memberVO.setMemberProfilePath("");
        memberVO.setMemberBackgroundName("");
        memberVO.setMemberBackgroundPath("");

        mypageMapper.update(memberVO);
    }
}
