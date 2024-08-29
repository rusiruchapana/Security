package com.rusiruchapana.security.test.repository;

import com.rusiruchapana.security.test.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser , Long> {

    Optional<MyUser> findByUsername(String username);
}
