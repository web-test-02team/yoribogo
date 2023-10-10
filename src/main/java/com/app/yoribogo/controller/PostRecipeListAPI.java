package com.app.yoribogo.controller;

import com.app.yoribogo.domain.PostDTO;
import com.app.yoribogo.service.PostRecipeListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController 는 주로 API를 구성할 때 사용
// 컨트롤러 내의 모든 메소드는 응답 본문(response body)에 직접 값을 반환
// List<PostDTO> 타입을 반환하는 메소드는 해당 리스트를 JSON 형식으로 변환하여 응답
// @RestController는 웹페이지 뷰를 반환하지 못하기 때문에 별도의 PostRecipeViewController 생성
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/posts/api/")
    public class PostRecipeListAPI {

        private final PostRecipeListService postRecipeListService;

        // 무료 레시피 목록 조회
        @GetMapping("recipe-list/free")
        public List<PostDTO> getFreeRecipes() {
            return postRecipeListService.getByFreeRecipeList();
        }

    //    @ApiOperation(value = "레시피 목록 조회", notes = "무료공유와 유료공유 목록을 조회할 수 있는 API")
    //    @ApiImplicitParam (
    //            name = "id",
    //            value = "게시글 번호",
    //            required = true,
    //            dataType = "long",
    //            paramType = "path",
    //            defaultValue = "none"
    //    )

    //     @ApiOperation(value = "레시피 목록 조회", notes = "무료공유와 유료공유 목록을 조회할 수 있는 API")
    //    @ApiImplicitParams({
    //            @ApiImplicitParam(name = "id", value = "게시글 번호", required = true, dataType = "long", paramType = "path",defaultValue = "none"),
    //            @ApiImplicitParam(name = "postTilte",value = "게시글 제목", required = true, dataType = "String", paramType = "path",defaultValue = "none"),
    //            @ApiImplicitParam(name = "postContent",value = "게시글 내용", required = true, dataType = "String", paramType = "path",defaultValue = "none"),
    //
    //    })

        // 유료 레시피 목록 조회
        @GetMapping("recipe-list/paid")
        public List<PostDTO> getPaidRecipes() {

            return postRecipeListService.getByPaidRecipeList();
        }
    }





//@RestController     // 응답 본문으로 직접 객체를 반환(@ResponseBody 포함)
//@RequestMapping("/posts/api/*")
//public class PostRecipeListController { //클라이언트의 HTTP 요청을 처리 및 응답을 반환
//
//    //    PostRecipeListService Type의 변수선언
//    private final PostRecipeListService postRecipeListService;
//
//    //    생성자 주입(Constructor Injection)을 사용하여 PostRecipeListService 객체를 (자동으로) 주입
////    PostRecipeListService 서비스를 컨트롤러에 주입하고 데이터를 가져옴
//    public PostRecipeListController(PostRecipeListService postRecipeListService) {
//        this.postRecipeListService = postRecipeListService;
//    }
//
//    //    레시피 목록 조회
////    @ApiOperation : Swagger에서 제공하는 어노테이션
////    Swagger UI에서 해당 API에 대한 설명을 표시하기 위해 사용
//    @ApiOperation(value = "레시피 목록 조회", notes = "무료공유와 유료공유 목록을 조회할 수 있는 API")
////    getPost()를 정의하고, URL에서 '{id}' 부분을 가져와 'Long'타입의 id를 매개변수로 받음
//    @GetMapping("/recipe/list/{id}")
//    public List<PostDTO> getPost(@PathVariable("id") Long id) {
////        서비스 객체의 메소드를 호출하여 무료공유 및 유료공유 레시피 목록을 조회
//        List<PostDTO> freeRecipes = postRecipeListService.getByFreeRecipeList(id);
//        List<PostDTO> paidRecipes = postRecipeListService.getByPaidRecipeList(id);
//
////      무료공유 및 유료공유 레시피를 합칠 새로운 목록을 초기화
//        List<PostDTO> allRecipes = new ArrayList<>();
////      allRecipes가 JSON으로 반환하고, 무료공유 및 유료공유 레시피를 allRecipes 목록에 추가
//        allRecipes.addAll(freeRecipes);
//        allRecipes.addAll(paidRecipes);
//
////      합쳐진 레시피 목록을 반환
//        return allRecipes;
//    }
//}



