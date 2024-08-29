package com.rusiruchapana.security.test.repository;

import com.rusiruchapana.security.test.entity.MyRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<MyRole , Long> {

    Optional<MyRole> findByName(String name);
}
