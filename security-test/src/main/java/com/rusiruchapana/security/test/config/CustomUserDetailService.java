package com.rusiruchapana.security.test.config;

import com.rusiruchapana.security.test.entity.Post;
import com.rusiruchapana.security.test.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Post post = postRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("username"));

        return new CustomeUserDetails(post);
    }
}
