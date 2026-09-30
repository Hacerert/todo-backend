package org.example.todoappp.controller;

import org.example.todoappp.entity.Todo;
import org.example.todoappp.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id,
                           @RequestBody Todo todo) {

        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow();

        existingTodo.setTitle(todo.getTitle());
        existingTodo.setCompleted(todo.isCompleted());

        return todoRepository.save(existingTodo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}