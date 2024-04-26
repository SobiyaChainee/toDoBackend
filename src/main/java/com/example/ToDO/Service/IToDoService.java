package com.example.ToDO.Service;

import com.example.ToDO.Entity.ToDo;
import com.example.ToDO.DTO.ToDoDto;

import java.util.List;
import java.util.Optional;

public interface IToDoService {

    List<ToDo> findAll();  // Fetch all To-Dos

    Optional<ToDo> findById(String id);  // Fetch a To-Do by ID

    ToDo create(ToDoDto dto);  // Create a new To-Do

    ToDo update(String id, ToDoDto dto);  // Update an existing To-Do

    void delete(String id);  // Delete a To-Do by ID
}