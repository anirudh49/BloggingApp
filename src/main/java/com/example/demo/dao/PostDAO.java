package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Post;

public interface PostDAO extends JpaRepository<Post, Integer>{

}
