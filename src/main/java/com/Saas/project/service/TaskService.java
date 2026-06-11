package com.Saas.project.service;

import com.Saas.project.entity.Task;
import com.Saas.project.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public Task createTask(Task task) {

        task.setStatus("Pending");
        task.setCreatedAt(LocalDateTime.now());

        return taskRepo.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public List<Task> getMyTasks(String email) {
        return taskRepo.findByAssignedToEmail(email);
    }

    public Task updateStatus(String id, String status) {

        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);

        return taskRepo.save(task);
    }
}