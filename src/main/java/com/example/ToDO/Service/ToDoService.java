package com.example.ToDO.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ToDO.ToDoRepo.ToDoRepository;
import com.example.ToDO.Entity.ToDo;
import com.example.ToDO.DTO.ToDoDto;
import com.example.ToDO.Service.IToDoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService implements IToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public Optional<ToDo> findById(String id) {
        return toDoRepository.findById(id);
    }

    @Override
    public ToDo create(ToDoDto dto) {
       // ToDo toDo = new ToDo(dto.getTitle(), dto.getDescription(), dto.isCompleted(), LocalDateTime.now());

            ToDo newToDo = new ToDo();
            newToDo.setTitle(dto.getTitle());
            newToDo.setDescription(dto.getDescription());
            newToDo.setCompleted(dto.isCompleted());
            newToDo.setCreatedAt(LocalDateTime.now());
            //return newToDo;

        return toDoRepository.save(newToDo);
    }

    @Override
    public ToDo update(String id, ToDoDto dto) {
        Optional<ToDo> existingToDo = toDoRepository.findById(id);
        if (existingToDo.isPresent()) {
            ToDo toDo = existingToDo.get();
            toDo.setTitle(dto.getTitle());
            toDo.setDescription(dto.getDescription());
            toDo.setCompleted(dto.isCompleted());
            return toDoRepository.save(toDo);
        } else {
            throw new RuntimeException("To-Do item not found");
        }
    }

    @Override
    public void delete(String id) {
        toDoRepository.deleteById(id);
    }
}

