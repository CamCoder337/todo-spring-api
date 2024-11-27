package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/todos")
public class ToDoController {
    private final TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> createATodo(@RequestBody Todo todo){
        Todo newTodo = todoService.createATodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> fetchAllTodos(){
        List<Todo> todos = todoService.collectAllTodo();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> fetchATodo(@PathVariable Long id){
        Todo todo = todoService.getATodo(id);
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateATodo(@PathVariable Long id, @RequestBody Todo updatedTodo){
        Todo updateTodoSaved = todoService.UpdateATodo(id, updatedTodo);
        return ResponseEntity.ok(updateTodoSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteATodo(@PathVariable Long id){
        todoService.deleteATodo(id);
        return ResponseEntity.noContent().build();
    }
}
