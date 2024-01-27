package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int category_id;
	@NotBlank
	private String category_title;
	@NotBlank
	@Length(min = 4, max = 200)
	private String category_description;

	@OneToMany(mappedBy = "category")
	private List<Post> posts = new ArrayList<>();
}