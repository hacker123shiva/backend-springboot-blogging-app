package com.shiva.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
