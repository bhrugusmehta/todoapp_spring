package com.livesoft.todoapp.service;

import com.livesoft.todoapp.model.Todo;
import com.livesoft.todoapp.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAll() {
        return  todoRepository.findAll();
    }

    public void deleteTodo(Long  id) {
        log.info("deleteID from service: {}", id);
        todoRepository.deleteById(id);
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
