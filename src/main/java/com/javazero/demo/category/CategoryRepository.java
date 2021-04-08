package com.javazero.demo.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByTypeCategory(String typeCategory);
}
