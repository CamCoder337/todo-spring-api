package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createATodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Optional<Todo> getATodo(Long todoId){
        return todoRepository.findById(todoId);
    }

    public void UpdateATodo(Todo updatedTodo){
        //todo: update code Logic !
    }

    public void deleteATodo(Long todoId){
        todoRepository.deleteById(todoId);
    }

    public List<Todo> collectAllTodo(){
        return todoRepository.findAll();
    }


}
