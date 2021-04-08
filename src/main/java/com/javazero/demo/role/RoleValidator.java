package com.javazero.demo.role;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
public class RoleValidator {

	public boolean isValid(Role todo) throws Exception {

		Optional<Role> optional = Optional.ofNullable(todo);

		// Kiểm tra name khác rỗng
		if (!optional.filter(t -> !StringUtils.isEmpty(t.getName())).isPresent()) {
			throw new Exception("The Name is not empty!");
		}

		return true;
	}
}
