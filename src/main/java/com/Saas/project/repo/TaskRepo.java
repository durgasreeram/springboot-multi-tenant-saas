package com.Saas.project.repo;

import com.Saas.project.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, String> {

    List<Task> findByAssignedToEmail(String email);

}