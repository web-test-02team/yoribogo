package com.app.yoribogo.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class RecipeVO implements Serializable {
    private Long id;
    private int recipePrice;
    private String recipeName;
    private String recipeContent;
    private String recipeFreeCheck;
    private String recipeSoldCheck;
    private Long postId;
}
