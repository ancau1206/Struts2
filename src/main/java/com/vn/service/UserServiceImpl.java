package com.vn.service;

import java.util.List;

import com.vn.dao.UserDAO;
import com.vn.dao.UserDAOImpl;
import com.vn.entity.Users;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDao = new UserDAOImpl();

	public List<Users> getAllUsers() {
		return userDao.getAll();
	}

	public Users findUsersById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteteUsers(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUsers(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createUsers(Users user) {
		
		return userDao.create(user);
	}

}
