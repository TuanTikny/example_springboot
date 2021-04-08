package com.javazero.demo.userprofile;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserProfileValidator {

	public boolean isValid(UserProfile userProfile) throws Exception {

		Optional<UserProfile> optional = Optional.ofNullable(userProfile);

		return true;
	}
}
