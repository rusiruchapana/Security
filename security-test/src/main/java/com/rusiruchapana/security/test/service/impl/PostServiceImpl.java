package com.rusiruchapana.security.test.service.impl;

import com.rusiruchapana.security.test.dto.request.PostRequestDTO;
import com.rusiruchapana.security.test.dto.response.PostResponseDTO;
import com.rusiruchapana.security.test.entity.Post;
import com.rusiruchapana.security.test.exception.ResourceNotFoundException;
import com.rusiruchapana.security.test.map.PostMapper;
import com.rusiruchapana.security.test.repository.PostRepository;
import com.rusiruchapana.security.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMapper postMapper;

    @Override
    public PostResponseDTO createPost(PostRequestDTO postRequestDTO) {
        Post post = postRepository.save(postMapper.dtoToEntity(postRequestDTO));
        return postMapper.entityToDTO(post);
    }

    @Override
    public List<PostResponseDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return postMapper.dtoToEntity(posts);
    }

    @Override
    public PostResponseDTO getPostById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            return postMapper.entityToDTO(post.get());
        }else {
            throw new ResourceNotFoundException("The given id is not in db.");
        }
    }

    @Override
    public PostResponseDTO updatePost(Long postId, PostRequestDTO postRequestDTO) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("The given id is not in db."));
        post.setTitle(postRequestDTO.getTitle());
        post.setDescription(postRequestDTO.getDescription());
        post.setContent(postRequestDTO.getContent());
        postRepository.save(post);
        return postMapper.entityToDTO(post);
    }

    @Override
    public String deletePostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("The given id is not in db."));
        postRepository.deleteById(postId);
        return "Post deleted sucess.";
    }
}
