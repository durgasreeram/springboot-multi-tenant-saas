package com.Saas.project.repo;

import com.Saas.project.entity.Tenant;
import com.Saas.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndTenant(String email, Tenant tenant);
}
