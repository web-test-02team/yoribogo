package com.app.yoribogo.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class ProfileVO implements Serializable {
    private Long id;
    private String profileUuid;
    private String profileFileName;
    private String profileFilePath;
    private String memberId;
}
