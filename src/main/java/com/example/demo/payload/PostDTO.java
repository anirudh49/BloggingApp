package com.example.demo.payload;

import java.util.Date;

import com.example.demo.entities.Category;
import com.example.demo.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

	private int post_id;
	private String title;
	private String content;
	private String image;
	private Category category;
	private User user;
	private Date addedDate;
	private int user_id;
	private int category_id;
	private byte[] imageData;
}
