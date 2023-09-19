package com.example.demo.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bo.UserBO;
import com.example.demo.dao.UserDAO;
import com.example.demo.entities.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.payload.UserDTO;

@Service
public class UserBoImpl implements UserBO {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user =  userDAO.save(dtoToUser(userDTO));
		return userToDTO(user);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, int userId) {
		User user = userDAO.findById(userId).get();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		
		userDAO.save(user);
		return userDTO;
	}

	@Override
	public UserDTO getUserById(int userId) throws UserNotFoundException {
		try{
			User user = userDAO.findById(userId).get();
			return userToDTO(user);
		}
		catch(Exception e) {
			throw new UserNotFoundException("User not found by this ID.");
		}
	}

	@Override
	public List<UserDTO> getallUsers() {
		List<User> users = new ArrayList<>();
		List<UserDTO> dtos = new ArrayList<>();
		users = userDAO.findAll();
		for(int i=0;i<users.size();i++) {
			dtos.add(userToDTO(users.get(i)));
		}
		return dtos;
	}

	@Override
	public String deleteUser(int userId) {
		userDAO.deleteById(userId);
		return "Selected user has been deleted.";
	}
	
	private User dtoToUser(UserDTO userdto) {
		User user = modelMapper.map(userdto, User.class);
		return user;
	}
	
	private UserDTO userToDTO(User user) {
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}
	
	

}
