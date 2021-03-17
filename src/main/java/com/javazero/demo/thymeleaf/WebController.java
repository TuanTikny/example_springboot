package com.javazero.demo.thymeleaf;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
  List<Todo> todoList = new CopyOnWriteArrayList<>();

  @GetMapping("/listTodo")
  public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
    model.addAttribute("todoList", limit != null ? todoList.subList(0, limit) : todoList);
    return "listTodo";
  }

  @GetMapping("/addTodo")
  public String addTodo(Model model) {
    model.addAttribute("todo", new Todo());
    return "addTodo";
  }

  @PostMapping("/addTodo")
  public String addTodo(@ModelAttribute Todo todo) {
    todoList.add(todo);
    return "success";
  }
}