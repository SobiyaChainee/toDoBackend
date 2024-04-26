package com.example.ToDO.DTO;

import java.time.LocalDateTime;

public class ToDoDto {
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;

    // Constructors
    public ToDoDto() {}

    public ToDoDto(String title, String description, boolean completed, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

