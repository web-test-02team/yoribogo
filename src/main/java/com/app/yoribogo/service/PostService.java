package com.app.yoribogo.service;

import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.mapper.PostMapper;

import java.util.List;
import java.util.Optional;

public interface PostService {
<<<<<<< HEAD
    // 무료목록
    public List<PostDTO> getByFreeReview() ;

    //유료목록
    public List<PostDTO> getByPaidReview();
=======
    public List<PostDTO> getByReview() ;

>>>>>>> 870ea3318898f6b70f9e511410bb32c67582c9dc
}
