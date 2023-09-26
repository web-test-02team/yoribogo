package com.app.yoribogo.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class LikeVO implements Serializable {
    private Long id;
    private Long memberId;
    private Long postId;
}
