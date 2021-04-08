package com.javazero.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findById(int id);
	
	Integer deleteById(int id);
	
	User findByUsername(String username);
}
