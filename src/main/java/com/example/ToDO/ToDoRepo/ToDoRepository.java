package com.example.ToDO.ToDoRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.ToDO.Entity.ToDo;

import java.time.LocalDateTime;
import java.util.List;

// Extend MongoRepository to provide basic CRUD operations
public interface ToDoRepository extends MongoRepository<ToDo, String> {

    // Custom queries can be defined here

    // Find all completed To-Do items
    List<ToDo> findByCompleted(boolean completed);

    // Find To-Do items by title (case-insensitive)
    List<ToDo> findByTitleContainingIgnoreCase(String title);

    // Find To-Do items created on or after a certain date
    List<ToDo> findByCreatedAtAfter(LocalDateTime date);
}