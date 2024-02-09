package com.example.demo.bo;

import com.example.demo.exception.CommentNotFoundException;
import com.example.demo.payload.CommentDTO;
import java.util.List;

public interface CommentBO {

	CommentDTO createComment(CommentDTO commentDTO);

	CommentDTO updateComment(CommentDTO commentDTO, int comment_id) throws CommentNotFoundException;

	String deleteComment(int comment_id);

	List<CommentDTO> findAll();

	CommentDTO findByName(int comment_id) throws CommentNotFoundException;
}
