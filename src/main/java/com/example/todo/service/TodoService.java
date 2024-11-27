package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Todo getATodo(Long todoId){
        Optional<Todo> existingTodo = todoRepository.findById(todoId);
        if(existingTodo.isPresent()){
            return existingTodo.get();
        }else {
        throw new EntityNotFoundException("Todo to fetch not found");
        }
    }

    public Todo UpdateATodo(Long id, Todo updatedTodo){
        Optional<Todo> todoToUpdate = todoRepository.findById(id);

        if(todoToUpdate.isPresent()){
            Todo oldTodo = todoToUpdate.get();
            oldTodo.setTitle(updatedTodo.getTitle());
            oldTodo.setDescription(updatedTodo.getDescription());
            oldTodo.setStatus(updatedTodo.getStatus());
            oldTodo.setPriority(updatedTodo.getPriority());

            return todoRepository.save(oldTodo);
        }else{
            throw new EntityNotFoundException("Todo to update not found");
        }
    }

    public void deleteATodo(Long todoId){
        todoRepository.deleteById(todoId);
    }

    public List<Todo> collectAllTodo(){
        return todoRepository.findAll();
    }


}
