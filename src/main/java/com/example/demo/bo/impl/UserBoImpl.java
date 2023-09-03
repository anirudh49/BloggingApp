package com.example.demo.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.bo.UserBO;
import com.example.demo.dao.UserDAO;
import com.example.demo.entities.User;
import com.example.demo.payload.UserDTO;

public class UserBoImpl implements UserBO {

	@Autowired
	private UserDAO userDAO; 
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user =  userDAO.save(dtoToUser(userDTO));
		return userToDTO(user);
	}

	@Override
	public UserDTO updateUser(UserDTO user, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getallUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}
	
	private User dtoToUser(UserDTO userdto) {
		User user = new User();
		user.setId(userdto.getId());
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
		return user;
	}
	
	private UserDTO userToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setAbout(user.getAbout());
		return userDTO;
	}
	
	

}
