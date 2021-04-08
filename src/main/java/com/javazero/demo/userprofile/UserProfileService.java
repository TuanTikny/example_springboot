package com.javazero.demo.userprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	

	@Autowired
	private UserProfileValidator validator;

	public UserProfile add(UserProfile userProfile) throws Exception {

		if (validator.isValid(userProfile)) {
			return userProfileRepository.save(userProfile);
		}

		throw new Exception("Validation user");
	}

}
