package com.javazero.demo.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findById(int id);
	
	Integer deleteById(int id);
	
	Role findByName(String name);
}