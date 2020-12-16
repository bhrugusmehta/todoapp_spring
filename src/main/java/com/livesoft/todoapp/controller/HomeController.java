package com.livesoft.todoapp.controller;

import com.livesoft.todoapp.model.Todo;
import com.livesoft.todoapp.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class HomeController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String homePage() {
        return "redirect:/list";
    }

    @PostMapping("/create")
    public String saveTodo(@ModelAttribute Todo todo ) {
        todoService.createTodo(todo);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listTodos(Model model) {
        List<Todo> todoList = todoService.getAll();
        if (todoList.isEmpty()) {
            todoList = null;
        }
        model.addAttribute("todos", todoList);
        return "todo_list_page";
    }

//    @GetMapping("/delete/{id}")
//    public String deleteTodo(Model model, @PathVariable Long id) {
//        Todo todo = todoService.findById(id);
//        if (todo != null) {
//            Boolean status = !todo.getStatus();
//            todo.setStatus(status);
//            todoService.deleteTodo(id);
//        }
//        return "redirect:/list";
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(Model model, @PathVariable Long id) {
        Todo todo = todoService.findById(id);
        if (todo != null) {
            Boolean status = !todo.getStatus();
            todo.setStatus(status);
            todoService.deleteTodo(id);
        }
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String updateTodo(Model model, @PathVariable Long id) {
        Todo todo = todoService.findById(id);
        if (todo != null) {
            Boolean status = !todo.getStatus();
            todo.setStatus(status);
            todoService.updateTodo(todo);
        }
        return "redirect:/list";
    }
//    @PutMapping("/update/{id}")
//    public String updateTodo(Model model, @PathVariable Long id) {
//        Todo todo = todoService.findById(id);
//        if (todo != null) {
//            Boolean status = !todo.getStatus();
//            todo.setStatus(status);
//            todoService.updateTodo(todo);
//        }
//        return "redirect:/list";
//    }
}
