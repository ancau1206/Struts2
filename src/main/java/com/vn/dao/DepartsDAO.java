package com.vn.dao;

import java.util.List;

import com.vn.entity.Departs;



public interface DepartsDAO {
	List<Departs> getAll();

	Departs findById(int id);
	
	Departs findByUserame(String username);

	boolean create(Departs departs);

	boolean update(Departs departs);

	boolean delete(Departs departs);
}
