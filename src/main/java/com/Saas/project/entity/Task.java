package com.Saas.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Setter
    private String title;

    @Setter
    private String description;

    @Setter
    private String assignedToEmail;

    @Setter
    private String priority;

    @Setter
    private String status;

    @Setter
    private LocalDate dueDate;

    @Setter
    private LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAssignedToEmail() {
        return assignedToEmail;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

}