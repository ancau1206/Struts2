package com.vn.dao;

import java.util.List;

import com.vn.entity.Users;

public interface UserDAO  {
	List<Users> getAll();

	Users findById(int id);
	
	Users findByUserame(String username);

	boolean create(Users admin);

	boolean update(Users admin);

	boolean delete(int id);
	

}
