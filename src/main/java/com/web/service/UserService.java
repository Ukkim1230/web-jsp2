package com.web.service;

import java.util.List;

import com.web.dao.UserDAO;
import com.web.dto.UserDTO;

public class UserService {
	private UserDAO userDAO = new UserDAO();
	
	public List<UserDTO> getUsers() {
		return userDAO.getUsers();
	}
	
	public UserDTO getUser(int uiNum) {
		return userDAO.getUser(uiNum);
	}
	
	public int insertUser(UserDTO user) {
		return userDAO.insertUser(user);
	}
	public int deleteUser(int uiNum) {
		return userDAO.deleteUser(uiNum);
	}
	public int updateUser(UserDTO user) {
		return userDAO.updateUser(user);
	}
}
