package com.shiva.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
