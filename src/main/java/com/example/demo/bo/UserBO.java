package com.example.demo.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.payload.UserDTO;

@Service
public interface UserBO {

	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user, int userId);
	UserDTO getUserById(int userId);
	List<UserDTO> getallUsers();
	String deleteUser(int userId);
}
