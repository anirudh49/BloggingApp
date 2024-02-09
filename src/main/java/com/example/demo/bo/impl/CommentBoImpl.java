package com.example.demo.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bo.CommentBO;
import com.example.demo.dao.CommentDAO;
import com.example.demo.entities.Comment;
import com.example.demo.exception.CommentNotFoundException;
import com.example.demo.payload.CommentDTO;

@Service
public class CommentBoImpl implements CommentBO {

	@Autowired
	CommentDAO commentDAO;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public CommentDTO createComment(CommentDTO commentDTO) {
		Comment comment = commentDAO.save(dtoToEntity(commentDTO));
		return entityToDTO(comment);
	}

	@Override
	public CommentDTO updateComment(CommentDTO commentDTO, int comment_id) throws CommentNotFoundException {
		try {
			Comment comment = commentDAO.findById(comment_id).get();
			comment.setContent(commentDTO.getContent());
			Comment updatedComment = commentDAO.save(comment);
			return entityToDTO(updatedComment);
		} catch (Exception e) {
			throw new CommentNotFoundException("Invalid comment Id!!");
		}
	}

	@Override
	public String deleteComment(int comment_id) {
		commentDAO.deleteById(comment_id);
		return "Selected comment has been deleted.";
	}

	@Override
	public List<CommentDTO> findAll() {
		List<CommentDTO> commentDTOs = new ArrayList<>();
		List<Comment> comments = new ArrayList<>();
		comments = commentDAO.findAll();
		for (int i = 0; i < comments.size(); i++) {
			commentDTOs.add(entityToDTO(comments.get(i)));
		}
		return commentDTOs;
	}

	@Override
	public CommentDTO findByName(int comment_id) throws CommentNotFoundException {
		try {
			Comment comment = commentDAO.findById(comment_id).get();
			return entityToDTO(comment);
		} catch (Exception e) {
			throw new CommentNotFoundException("Invalid comment Id!!");
		}
	}

	private Comment dtoToEntity(CommentDTO commentDTO) {
		Comment comment = modelMapper.map(commentDTO, Comment.class);
		return comment;
	}

	private CommentDTO entityToDTO(Comment comment) {
		CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
		return commentDTO;
	}

}
