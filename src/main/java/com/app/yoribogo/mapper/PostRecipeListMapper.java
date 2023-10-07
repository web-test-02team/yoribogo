package com.app.yoribogo.mapper;

import com.app.yoribogo.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PostRecipeListMapper {
//    레시피목록
    public List<PostDTO> selectByRecipeListFree();
    public List<PostDTO> selectByRecipeList();

//    조회수 증가
//    public void updatePostHits(Long postId);
}
