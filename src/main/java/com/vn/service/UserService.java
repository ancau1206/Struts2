package com.vn.service;

import java.util.List;

import com.vn.entity.Users;

public interface UserService {
	List<Users> getAllUsers();

	Users findUsersById(int id);

	boolean deleteteUsers(int id);

	boolean updateUsers(Users user);

	boolean createUsers(Users user);

}
