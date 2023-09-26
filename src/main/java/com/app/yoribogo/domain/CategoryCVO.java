package com.app.yoribogo.domain;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class CategoryCVO implements Serializable {
    private Long id;
    private String CategoryCAName;
    private String CategoryBId;

}
