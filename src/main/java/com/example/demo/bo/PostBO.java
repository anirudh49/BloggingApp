package com.example.demo.bo;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.PostNotFoundException;
import com.example.demo.payload.PostDTO;

public interface PostBO {

	//create
//	PostDTO createPost(PostDTO postDTO, MultipartFile multipartFile) throws IOException;
	PostDTO createPost(PostDTO postDTO) throws IOException;
	//update
	PostDTO updatePost(PostDTO postDTO, int postId, MultipartFile multipartFile);
	//getbyid
	PostDTO getPostById(int postId) throws PostNotFoundException;
	//getall
	List<PostDTO> getAllPosts();
	//delete
	String deletePost(int postId) throws PostNotFoundException;
}
