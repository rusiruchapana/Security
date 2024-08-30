package com.rusiruchapana.security.test.repository;

import com.rusiruchapana.security.test.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post , Long> {

    Optional<Post> findByUsername(String username);
}
