package com.app.yoribogo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class PostFileVO implements Serializable {
    private Long id;
    private String postFileName;
    private String postFilePath;
    private String postFileUuid;
    private Long postId;
}
