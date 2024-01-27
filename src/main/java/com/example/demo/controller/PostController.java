package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bo.PostBO;
import com.example.demo.entities.Post;
import com.example.demo.exception.PostNotFoundException;
import com.example.demo.payload.PostDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {

	
	
	@Autowired
	PostBO postBO;
	
	//create
//	@PostMapping("/createPost")
//	public PostDTO createPost(@Valid @RequestPart("postDTO") PostDTO postDTO, @RequestPart("image") MultipartFile multipartFile) throws IOException {
//		return postBO.createPost(postDTO, multipartFile);
//	}
	@PostMapping("/createPost")
	public String createPost(@Valid @RequestBody PostDTO postDTO) throws IOException {
		PostDTO result = postBO.createPost(postDTO);
		if(result!=null)
		return "Post saved successfully";
		else
			return "Error occured.";
	}
	//update
	@PutMapping("/updatePost/{postId}")
	public PostDTO updatePost(@RequestBody PostDTO postDTO, @PathVariable("postId") Integer postId, @RequestParam("image") MultipartFile multipartFile) {
		return postBO.updatePost(postDTO, postId, multipartFile);
	}
	//findbyid
	@GetMapping("/findPostById/{postId}")
	public PostDTO findById(@PathVariable("userId") Integer postId) throws PostNotFoundException {
		return postBO.getPostById(postId);
	}
	
	@GetMapping("/findAll")
	public List<PostDTO> findAll(){
		return postBO.getAllPosts();
	}
	
	@DeleteMapping("/deletePost/{postId}")
	public String delete(@RequestParam("postId") Integer postId) throws PostNotFoundException {
		return postBO.deletePost(postId);
	}
}
