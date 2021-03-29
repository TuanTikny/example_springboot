package com.javazero.demo.todolist;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {

	@Autowired
	private TodoService todoService;

	@PostConstruct
	public void init() {
		// todo before run this Bean RestApiController
	}

	@GetMapping("/todos")
	public List<Todo> getTodoList(@RequestParam Integer limit) {
		return todoService.findAll(limit);
	}

	@GetMapping("/todo/{todoId}")
	public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) throws Exception {
		return todoService.findById(todoId);
	}

	@DeleteMapping("/todo/{todoId}")
	public int deleteTodo(@PathVariable(name = "todoId") Integer todoId) throws Exception {
		return todoService.remove(todoId);
	}

	// post add update sài chung, sửa thì thêm id vào Object
	@PostMapping("/todo")
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) throws Exception {
		Todo newtodo = todoService.add(todo);
		return ResponseEntity.ok().body(newtodo);
	}
}
