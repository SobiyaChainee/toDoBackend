package com.example.ToDO.ToDoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ToDO.Service.ToDoService;
import com.example.ToDO.DTO.ToDoDto;
import com.example.ToDO.Entity.ToDo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/getAllToDoItems")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ToDo>> getAllToDos() {
        return ResponseEntity.ok(toDoService.findAll());
    }

    @GetMapping("/getToDoItemById/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ToDo> getToDoById(@PathVariable String id) {
        Optional<ToDo> toDo = toDoService.findById(id);
        if (toDo.isPresent()) {
            return ResponseEntity.ok(toDo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveToDoItem")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDoDto dto) {
        ToDo newToDo = toDoService.create(dto);
        return ResponseEntity.ok(newToDo);
    }

    @PutMapping("/editToDoItem/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ToDo> updateToDo(@PathVariable String id, @RequestBody ToDoDto dto) {
        try {
            ToDo updatedToDo = toDoService.update(id, dto);
            return ResponseEntity.ok(updatedToDo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteToDoItem/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> deleteToDo(@PathVariable String id) {
        try {
            toDoService.delete(id);
            return ResponseEntity.ok("deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
