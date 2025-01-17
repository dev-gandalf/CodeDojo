package com.groupone.shazar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupone.shazar.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
}
