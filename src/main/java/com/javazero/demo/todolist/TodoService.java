package com.javazero.demo.todolist;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private TodoValidator validator;

	/**
	 * Hàm này trả về danh sách todo.
	 * 
	 * @param limit : giới hạn phần tử trả về 
	 * @return List<Todo> : trả về một danh sách todo  
	 */
	public List<Todo> findAll(Integer limit) {

		return Optional.ofNullable(limit).map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
				.orElseGet(() -> todoRepository.findAll());
	}

	/**
	 * Trả về todo có id = todoId.
	 * 
	 * @param todoId ( id của todo cần lấy về)
	 * @return todo ( trả về phần tử tìm được, throw về lỗi nếu không tìm được
	 */
	public Todo findById(Integer todoId) throws Exception {

		Todo todo = todoRepository.findById(todoId);
		if (todo == null) {
			throw new Exception("Can't find the Todo");
		}

		return todo;
	}

	public Todo add(Todo todo) {

		if (validator.isValid(todo)) {
			return todoRepository.save(todo);
		}

		return null;
	}

	public int remove(Integer todoId) throws Exception {

		Integer flagRm = todoRepository.deleteById(todoId);
		System.out.println("check " + flagRm);

		if (flagRm <= 0) {
			throw new Exception("The todo is not exits");
		}

		return flagRm;
	}
}
