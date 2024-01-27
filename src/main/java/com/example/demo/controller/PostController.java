package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.payload.FullPostDTO;
import com.example.demo.payload.SimplifiedDTO;

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
	public String createPost(@Valid @RequestPart(value = "postDTO", required = true) FullPostDTO postDTO, @RequestPart(value = "image", required = false) MultipartFile multipartFile) throws IOException {
		FullPostDTO result = postBO.createPost(postDTO, multipartFile);
		if(result!=null)
		return "Post saved successfully";
		else
			return "Error occured.";
	}
	//update
	@PutMapping("/updatePost/{postId}")
	public FullPostDTO updatePost(@RequestBody FullPostDTO postDTO, @PathVariable("postId") Integer postId, @RequestParam("image") MultipartFile multipartFile) {
		return postBO.updatePost(postDTO, postId, multipartFile);
	}
	//findbyid
	@GetMapping("/findPostById/{postId}")
	public SimplifiedDTO findPostById(@PathVariable("postId") Integer postId) throws PostNotFoundException {
		SimplifiedDTO postDTO = postBO.getPostById(postId);
		return postDTO;
	}
	
	@GetMapping("/findPostImageById/{postId}")
	public ResponseEntity<?> findPostImageById(@PathVariable("postId") Integer postId) throws PostNotFoundException {
		byte[] imageData = postBO.getPostImageById(postId).getImageData();
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
	}
	
	@GetMapping("/findAll")
	public List<FullPostDTO> findAll(){
		return postBO.getAllPosts();
	}
	
	@DeleteMapping("/deletePost/{postId}")
	public String delete(@RequestParam("postId") Integer postId) throws PostNotFoundException {
		return postBO.deletePost(postId);
	}
}
