package com.rusiruchapana.security.test.service;

import com.rusiruchapana.security.test.dto.request.PostRequestDTO;
import com.rusiruchapana.security.test.dto.response.PostResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostResponseDTO createPost(PostRequestDTO postRequestDTO);

    List<PostResponseDTO> getAllPosts();

    PostResponseDTO getPostById(Long postId);

    PostResponseDTO updatePost(Long postId, PostRequestDTO postRequestDTO);

    String deletePostById(Long postId);
}
