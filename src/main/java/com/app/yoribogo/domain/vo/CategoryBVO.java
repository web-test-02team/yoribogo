package com.app.yoribogo.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class CategoryBVO implements Serializable {
    private Long id;
    private String CategoryBAName;
    private String CategoryAId;

}