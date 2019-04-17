package com.vn.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.vn.dao.RecordsImpl;
import com.vn.dao.StaffsDAOImpl;
import com.vn.entity.Records;
import com.vn.entity.Staffs;

@Action(value = "addRecords", results = { @Result(name = "input", location = "/WEB-INF/pages/records/addRecords.jsp"),
		@Result(name = "error", location = "/WEB-INF/pages/records/addRecords.jsp"),
		@Result(name = "success", type = "redirect", location = "/recordStaffs" ) })
public class AddRecords extends ActionSupport implements ServletRequestAware{
	 private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	StaffsDAOImpl daoImpl = new StaffsDAOImpl();
	RecordsImpl recordsImpl=new RecordsImpl();
	Staffs staffs;
	private int type;
    private String reason;
	private Date date;
	private int id;
	
	@Override
	public String execute() throws Exception {
		if (request.getMethod().equals("GET")) {
			System.out.println(getId());
			staffs= daoImpl.findById(getId());
			return INPUT;
		}
		try {
			long millis=System.currentTimeMillis();
			date= new java.sql.Date(millis);
			staffs= daoImpl.findById(getStaffs().getId());
	
			Records records=new Records(getStaffs(), getType(), getReason(),getDate());

			boolean kq =recordsImpl.insertRecord(records);

			
			if(kq) {
				HttpSession session = request.getSession();
				session.setAttribute("reason", reason);
				session.setAttribute("records", records);
				return SUCCESS;
			}
			addActionError("Lỗi thêm phòng ban");
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Lỗi thêm phòng ban");
			return ERROR;
		}
	}
	
	
	public Staffs getStaffs() {
		return staffs;
	}


	public void setStaffs(Staffs staffs) {
		this.staffs = staffs;
	}

	

	


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

}
