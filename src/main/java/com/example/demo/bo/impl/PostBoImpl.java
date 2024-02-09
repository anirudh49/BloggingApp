package com.example.demo.bo.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.example.demo.payload.CategoryDTO;
import com.example.demo.payload.FullPostDTO;
import com.example.demo.payload.SimplifiedDTO;
import com.example.demo.payload.UserDTO;

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
	public FullPostDTO createPost(FullPostDTO postDTO, MultipartFile multipartFile) throws IOException {
		postDTO.setAddedDate(new Date());
		UserDTO user = userToDTO(userDAO.findById(postDTO.getUser_id()).get());
		CategoryDTO category = entityToDTO(categoryDAO.findById(postDTO.getCategory_id()).get());
		postDTO.setCategory(category);
		postDTO.setUser(user);
		Post onlyImage = Post.builder()
				.imageData(multipartFile.getBytes()).build();
		Post postWithImage = dtoToEntity(postDTO);
		postWithImage.setImageData(onlyImage.getImageData());
		postDAO.save(postWithImage);
		return entityToDTO(postWithImage);
	}

	@Override
	public FullPostDTO updatePost(FullPostDTO postDTO, int postId, MultipartFile multipartFile) {
		Post post = postDAO.findById(postId).get();
		post.setPost_id(postDTO.getPost_id());
		post.setTitle(postDTO.getTitle());
		post.setImage(postDTO.getImage());
		post.setContent(postDTO.getImage());
		post.setCategory(dtoToEntity(postDTO.getCategory()));
		postDAO.save(post);
		return entityToDTO(post);
	}

	@Override
	public FullPostDTO getPostImageById(int postId) throws PostNotFoundException {
		try {
			return entityToDTO(postDAO.findById(postId).get());
		}
		catch(Exception e) {
			throw new PostNotFoundException("Invalid post Id.");
		}
	}
	
	@Override
	public SimplifiedDTO getPostById(int postId) throws PostNotFoundException {
	    Optional<Post> postOptional = postDAO.findById(postId);
	    if (postOptional.isPresent()) {
	        return entityToSimplDTO(postOptional.get());
	    } else {
	        throw new PostNotFoundException("Post not found with id: " + postId);
	    }
	}

	@Override
	public List<FullPostDTO> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		List<FullPostDTO> postDTOs = new ArrayList<>();
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
	
	FullPostDTO entityToDTO(Post post) {
		FullPostDTO postDTO = modelMapper.map(post, FullPostDTO.class);
		return postDTO;
	}
	
	SimplifiedDTO entityToSimplDTO(Post post) {
		SimplifiedDTO postDTO = modelMapper.map(post, SimplifiedDTO.class);
		return postDTO;
	}
	
	Post dtoToEntity(FullPostDTO postDTO) {
		Post post = modelMapper.map(postDTO, Post.class);
		return post;
	}
	
	CategoryDTO entityToDTO(Category category) {
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}
	
	private UserDTO userToDTO(User user) {
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}
	
	Category dtoToEntity(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		return category;
	}

}
