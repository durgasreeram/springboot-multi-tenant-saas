package com.Saas.project.repo;

import com.Saas.project.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;



public interface TenantRepo extends JpaRepository<Tenant, UUID> {

    Optional<Tenant> findBySlug(String slug);

}
