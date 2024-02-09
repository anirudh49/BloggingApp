package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.CommentBO;
import com.example.demo.exception.CommentNotFoundException;
import com.example.demo.payload.CommentDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	private CommentBO commentBO;
	
	@PostMapping("/createComment")
	public CommentDTO createComment(@Valid @RequestBody CommentDTO commentDTO) {
		return commentBO.createComment(commentDTO);
	}
	
	@PutMapping("/updateComment/{commentId}")
	public CommentDTO updateComment(@Valid @RequestBody CommentDTO commentDTO, @PathVariable("commentId") Integer commentId) throws CommentNotFoundException {
		return commentBO.updateComment(commentDTO, commentId);
	}
	
	@DeleteMapping("/deleteComment/{commentId}")
	public String deleteComment(@PathVariable("commentId") Integer commentId) {
		return commentBO.deleteComment(commentId);
	}
	
	@GetMapping("/findAll")
	public List<CommentDTO> findAll(){
		List<CommentDTO> commentDTOs = new ArrayList<>();
		commentDTOs = commentBO.findAll();
		return commentDTOs;
	}
	
	@GetMapping("/findById/{commentId}")
	public CommentDTO findById(@PathVariable("commentId") Integer commentId) throws CommentNotFoundException {
		return commentBO.findByName(commentId);
	}
}
