package com.javazero.demo.post;

import java.util.Optional;

import org.springframework.stereotype.Component;


@Component
public class PostValidator {
	public boolean isValid(Post post) throws Exception {

		Optional<Post> optional = Optional.ofNullable(post);

		return true;
	}
}
