package com.vn.service;

import java.util.List;

import com.vn.entity.Departs;

public interface DepartsService {
	List<Departs> getAll();

	Departs findById(int id);
	
	Departs findByUserame(String username);

	boolean create(Departs departs);

	boolean update(Departs departs);

	boolean delete(int id);
}
