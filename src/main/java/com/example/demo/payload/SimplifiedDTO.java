package com.example.demo.payload;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedDTO {

	private int post_id;
	private String title;
	private String content;
	private String image;
	private CategoryDTO category;
	private UserDTO user;
	private CommentDTO comment;
	private Date addedDate;
	private int user_id;
	private int category_id;
	private int comment_id;
}
