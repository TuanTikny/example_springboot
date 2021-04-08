package com.javazero.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryValidator validator;

	public Category add(Category category) throws Exception {

		if (validator.isValid(category)) {
			return categoryRepository.save(category);
		}

		throw new Exception("Validation category");
	}
}
