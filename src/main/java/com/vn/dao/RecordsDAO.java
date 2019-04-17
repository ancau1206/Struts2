package com.vn.dao;

import java.util.List;

import com.vn.entity.Records;
import com.vn.entity.Staffs;



public interface RecordsDAO {
	List<Object[]> getTop10Records();
	List<Object[]> getListRecords();
	List<Object[]> getListRecordsDeparts();
	boolean insertRecord(Records records);
}
