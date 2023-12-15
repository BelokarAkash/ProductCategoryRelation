package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
 
}
