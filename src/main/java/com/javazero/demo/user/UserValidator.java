package com.javazero.demo.user;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
public class UserValidator {

	public boolean isValid(User user) throws Exception {

		Optional<User> optional = Optional.ofNullable(user);

		// Kiểm tra name khác rỗng
		if (!optional.filter(t -> !StringUtils.isEmpty(t.getFullname())).isPresent()) {
			throw new Exception("The Name is not empty!");
		}
		// Kiểm tra name khác rỗng
		if (!optional.filter(t -> !StringUtils.isEmpty(t.getPassword())).isPresent()) {
			throw new Exception("The PassWord is not empty!");
		}

		return true;
	}
}
