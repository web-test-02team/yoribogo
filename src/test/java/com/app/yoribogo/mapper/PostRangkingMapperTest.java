package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.domain.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostRangkingMapperTest {

    @Autowired
    private PostRangkingMapper postRangkingMapper;

    @Test
    public void selectTest() {
        postRangkingMapper.selectByRangking().stream().map(PostDTO::toString).forEach(item -> log.info(item));
    }
}

