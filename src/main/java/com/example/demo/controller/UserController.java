package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.UserBO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.payload.UserDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserBO userBO;
	
	
	
	@PostMapping("/createUser")
	public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
		return userBO.createUser(userDTO);
	}
	
	@PutMapping("/updateUser/{userId}")
	public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO, @RequestParam("userId") Integer userId) {
		return userBO.updateUser(userDTO, userId);
	}
	
	
	@GetMapping("/findById/{userId}")
	public UserDTO findById(@RequestParam("userId") Integer userId) throws UserNotFoundException {
		return userBO.getUserById(userId);
	}
	
	@GetMapping("/findAll")
	public List<UserDTO> findAll(){
		return userBO.getallUsers();
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String delete(@RequestParam("userId") Integer userId) {
		return userBO.deleteUser(userId);
	}
}
