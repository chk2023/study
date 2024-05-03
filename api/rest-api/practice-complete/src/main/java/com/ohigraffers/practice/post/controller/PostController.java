package com.ohigraffers.practice.post.controller;

import com.ohigraffers.practice.post.dto.request.PostCreateRequest;
import com.ohigraffers.practice.post.dto.request.PostUpdateRequest;
import com.ohigraffers.practice.post.dto.response.PostResponse;
import com.ohigraffers.practice.post.dto.response.ResponseMessage;
import com.ohigraffers.practice.post.model.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Post 기능 테스트")
@RestController
@RequestMapping("/posts")
public class PostController {

    private List<Post> posts;

    public PostController(){
        posts = new ArrayList<>();
        posts.add(new Post(1L, "제목1", "내용1", "홍길동"));
        posts.add(new Post(2L, "제목2", "내용2", "유관순"));
        posts.add(new Post(3L, "제목3", "내용3", "신사임당"));
        posts.add(new Post(4L, "제목4", "내용4", "이순신"));
        posts.add(new Post(5L, "제목5", "내용5", "장보고"));
    }

    @Operation(summary = "전체 포스트 조회")
    @GetMapping
    public ResponseEntity<ResponseMessage> findAllPosts() {

        List<EntityModel<PostResponse>> postsWithRel =
                posts.stream().map(
                        post -> EntityModel.of(
                                    PostResponse.from(post),
                                    linkTo(methodOn(PostController.class).findPostByCode(post.getCode())).withSelfRel(),
                                    linkTo(methodOn(PostController.class).findAllPosts()).withRel("posts")
                                )
                        ).toList();

        return ResponseEntity
                .ok()
                .body(new ResponseMessage(200, "조회 성공", Map.of("posts", postsWithRel)));
    }

    @Operation(summary = "특정 코드로 포스트 조회")
    @GetMapping("{code}")
    public ResponseEntity<ResponseMessage> findPostByCode(@PathVariable Long code) {

        Post foundPost = posts.stream().filter(post -> Objects.equals(post.getCode(), code)).toList().get(0);

        EntityModel<PostResponse> postWithRel =
            EntityModel.of(
                PostResponse.from(foundPost),
                linkTo(methodOn(PostController.class).findPostByCode(code)).withSelfRel(),
                linkTo(methodOn(PostController.class).findAllPosts()).withRel("posts")
            );

        return ResponseEntity
                .ok()
                .body(new ResponseMessage(200, "조회 성공", Map.of("post", postWithRel)));
    }

    @Operation(summary = "신규 포스트 등록")
    @PostMapping
   public ResponseEntity<?> registPost(@Valid @RequestBody PostCreateRequest postCreateRequest) {

       Long newCode = posts.get(posts.size() - 1).getCode() + 1;

       posts.add(new Post(newCode, postCreateRequest.getTitle(), postCreateRequest.getContent(), postCreateRequest.getWriter()));

       return ResponseEntity
               .created(URI.create("/posts/" + posts.get(posts.size() - 1).getCode()))
               .build();
   }

    @Operation(summary = "포스트 제목, 내용 수정")
    @PutMapping("{code}")
    public ResponseEntity<?> modifyPost(@PathVariable Long code, @Valid @RequestBody PostUpdateRequest postUpdateRequest) {

        Post foundPost = posts.stream().filter(post -> Objects.equals(post.getCode(), code)).toList().get(0);

        foundPost.modifyTitleAndContent(postUpdateRequest.getTitle(), postUpdateRequest.getContent());

        return ResponseEntity
                .created(URI.create("/posts/" + code))
                .build();
    }

    @Operation(summary = "포스트 삭제")
    @DeleteMapping("{code}")
    public ResponseEntity<?> removeUser(@PathVariable Long code) {

        Post foundPost = posts.stream().filter(post -> Objects.equals(post.getCode(), code)).toList().get(0);
        posts.remove(foundPost);

        return ResponseEntity
                .noContent()
                .build();
    }

}
