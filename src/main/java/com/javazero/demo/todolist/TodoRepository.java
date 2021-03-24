package com.javazero.demo.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	Todo findById(int id);

	Integer deleteById(int id);
}