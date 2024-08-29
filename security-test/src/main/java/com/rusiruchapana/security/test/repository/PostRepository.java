package com.rusiruchapana.security.test.repository;

import com.rusiruchapana.security.test.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post , Long> {
}
