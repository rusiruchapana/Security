package com.rusiruchapana.security.test.controller;

import com.rusiruchapana.security.test.dto.request.PostRequestDTO;
import com.rusiruchapana.security.test.dto.response.PostResponseDTO;
import com.rusiruchapana.security.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/post")
public class PostController {

    @Autowired
    private PostService postService;
    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO postRequestDTO){
        PostResponseDTO postResponseDTO = postService.createPost(postRequestDTO);
        return new ResponseEntity<>(
                postResponseDTO,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPost(){
        List<PostResponseDTO> postResponseDTOS = postService.getAllPosts();
        return new ResponseEntity<>(
                postResponseDTOS,
                HttpStatus.OK
        );
    }

    @GetMapping(params = {"id"})
    public ResponseEntity<PostResponseDTO> getOnePost(@RequestParam("id") Long postId){
        PostResponseDTO postResponseDTO = postService.getPostById(postId);
        return new ResponseEntity<>(
                postResponseDTO,
                HttpStatus.OK
        );
    }

    @PutMapping(params = {"id"})
    public ResponseEntity<PostResponseDTO> updatePost(@RequestParam("id") Long postId , @RequestBody PostRequestDTO postRequestDTO){
        PostResponseDTO postResponseDTO = postService.updatePost(postId , postRequestDTO);
        return new ResponseEntity<>(
                postResponseDTO,
                HttpStatus.OK
        );
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<String> deleteOnePost(@RequestParam("id") Long postId){
        String msg = postService.deletePostById(postId);
        return new ResponseEntity<>(
                msg,
                HttpStatus.OK
        );
    }


}
