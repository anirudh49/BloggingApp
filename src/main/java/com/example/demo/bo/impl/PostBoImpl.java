package com.example.demo.bo.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bo.PostBO;
import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.PostDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.exception.PostNotFoundException;
import com.example.demo.payload.PostDTO;

@Service
public class PostBoImpl implements PostBO {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	PostDAO postDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
//	@Override
//	public PostDTO createPost(PostDTO postDTO, MultipartFile multipartFile) throws IOException {
//		postDTO.setAddedDate(new Date());
//		User user = userDAO.findById(postDTO.getUser_id()).get();
//		Category category = categoryDAO.findById(postDTO.getCategory_id()).get();
//		postDTO.setCategory(category);
//		postDTO.setUser(user);
//		Post post = dtoToEntity(postDTO);
//		post = Post.builder()
//				.imageData(multipartFile.getBytes()).build();
//		return entityToDTO(post);
//	}
	
	@Override
	public PostDTO createPost(PostDTO postDTO) throws IOException {
		postDTO.setAddedDate(new Date());
		User user = userDAO.findById(postDTO.getUser_id()).get();
		Category category = categoryDAO.findById(postDTO.getCategory_id()).get();
		postDTO.setCategory(category);
		postDTO.setUser(user);
		Post post = dtoToEntity(postDTO);
		return entityToDTO(post);
	}

	@Override
	public PostDTO updatePost(PostDTO postDTO, int postId, MultipartFile multipartFile) {
		Post post = postDAO.findById(postId).get();
		post.setPost_id(postDTO.getPost_id());
		post.setTitle(postDTO.getTitle());
		post.setImage(postDTO.getImage());
		post.setContent(postDTO.getImage());
		post.setCategory(postDTO.getCategory());
		postDAO.save(post);
		return entityToDTO(post);
	}

	@Override
	public PostDTO getPostById(int postId) throws PostNotFoundException {
		try {
			return entityToDTO(postDAO.findById(postId).get());
		}
		catch(Exception e) {
			throw new PostNotFoundException("Invalid post Id.");
		}
	}

	@Override
	public List<PostDTO> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		List<PostDTO> postDTOs = new ArrayList<>();
		posts = postDAO.findAll();
		for(int i=0;i<posts.size();i++) {
			postDTOs.add(entityToDTO(posts.get(i)));
		}
		return postDTOs;
	}

	@Override
	public String deletePost(int postId) throws PostNotFoundException {
		try {
			postDAO.deleteById(postId);
			return "Post deleted successfully";
		}
		catch(Exception e) {
			throw new PostNotFoundException("Invalid post Id.");
		}	
		
	}
	
	PostDTO entityToDTO(Post post) {
		PostDTO postDTO = modelMapper.map(post, PostDTO.class);
		return postDTO;
	}
	
	Post dtoToEntity(PostDTO postDTO) {
		Post post = modelMapper.map(postDTO, Post.class);
		return post;
	}

}
