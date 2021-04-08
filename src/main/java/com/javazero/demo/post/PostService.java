package com.javazero.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	
	@Autowired
	private PostRepository postProfileRepository;

	@Autowired
	private PostValidator validator;

	public Post add(Post post) throws Exception {

		if (validator.isValid(post)) {
			return postProfileRepository.save(post);
		}

		throw new Exception("Validation post");
	}
}
