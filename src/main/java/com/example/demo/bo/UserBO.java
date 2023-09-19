package com.example.demo.bo;

import java.util.List;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.payload.UserDTO;


public interface UserBO {

	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user, int userId);
	UserDTO getUserById(int userId) throws UserNotFoundException;
	List<UserDTO> getallUsers();
	String deleteUser(int userId);
}
