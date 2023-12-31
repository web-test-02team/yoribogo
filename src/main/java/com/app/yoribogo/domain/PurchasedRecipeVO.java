package com.app.yoribogo.domain;

import lombok.Data;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class PurchasedRecipeVO implements Serializable {
    private Long id;
    private Long recipeId;
    private Long purchaseId;
}
