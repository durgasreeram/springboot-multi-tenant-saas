package com.Saas.project.controller;

import com.Saas.project.entity.Task;
import com.Saas.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/my")
    public List<Task> getMyTasks(Authentication authentication) {

        String email = authentication.getName();

        return taskService.getMyTasks(email);
    }

    @PutMapping("/{id}/status")
    public Task updateStatus(
            @PathVariable String id,
            @RequestParam String status
    ) {
        return taskService.updateStatus(id, status);
    }
}