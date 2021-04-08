package com.javazero.demo.userprofile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	UserProfile findById(int id);

	Integer deleteById(int id);
}
