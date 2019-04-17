package com.vn.dao;

import java.util.List;


import com.vn.entity.Staffs;

public interface StaffsDAO {
	List<Staffs> getAll();

	Staffs findById(int id);
	
	Staffs findByCodeId(String codeId);

	boolean create(Staffs staffs);

	boolean update(Staffs staffs);

	boolean delete(Staffs staffs);
}
