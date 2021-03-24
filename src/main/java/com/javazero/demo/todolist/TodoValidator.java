package com.javazero.demo.todolist;

import java.util.Optional;

import org.thymeleaf.util.StringUtils;

/*
Đối tượng này dùng để kiểm tra xem một Object Todo có hợp lệ không
 */
public class TodoValidator {

	/**
	 * Kiểm tra một object Todo có hợp lệ không
	 * 
	 * @param todo
	 * @return
	 */
	public boolean isValid(Todo todo) throws Exception {

		Optional<Todo> optional = Optional.ofNullable(todo);

		// Kiểm tra title khác rỗng
		if (!optional.filter(t -> !StringUtils.isEmpty(t.getTitle())).isPresent()) {
			throw new Exception("The Title is not empty!");
		}

		// Kiểm tra detail khác rỗng
		if (!optional.filter(t -> !StringUtils.isEmpty(t.getDetail())).isPresent()) {
			throw new Exception("The Detail is not empty!");
		}

		return true;
	}
}