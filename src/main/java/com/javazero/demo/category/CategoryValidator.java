package com.javazero.demo.category;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class CategoryValidator {
	
	public boolean isValid(Category category) throws Exception {

		Optional<Category> optional = Optional.ofNullable(category);

		return true;
	}
}
