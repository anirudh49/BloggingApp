package com.example.demo.bo;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.PostNotFoundException;
import com.example.demo.payload.FullPostDTO;
import com.example.demo.payload.SimplifiedDTO;

public interface PostBO {

	//create
	FullPostDTO createPost(FullPostDTO postDTO, MultipartFile multipartFile) throws IOException;
	//PostDTO createPost(PostDTO postDTO) throws IOException;
	//update
	FullPostDTO updatePost(FullPostDTO postDTO, int postId, MultipartFile multipartFile);
	FullPostDTO updatePostImage(FullPostDTO postDTO, int postId, MultipartFile multipartFile) throws IOException;
	//getbyid
	FullPostDTO getPostImageById(int postId) throws PostNotFoundException;
	
	SimplifiedDTO getPostById(int postId) throws PostNotFoundException;
	//getall
	List<FullPostDTO> getAllPosts();
	//delete
	String deletePost(int postId) throws PostNotFoundException;
}
