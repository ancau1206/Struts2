package com.vn.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import com.vn.dao.StaffsDAOImpl;

import com.vn.entity.Staffs;

@Action(value = "deleteStaffs", results = {
		@Result(name = "error", location = "/WEB-INF/pages/staffs/listStaffs.jsp"),
		@Result(name = "success", type = "redirect", location = "/listStaffs") })
public class DeleteStaffs extends ActionSupport implements ServletRequestAware{
	HttpServletRequest request;
	private static final long serialVersionUID = 1L;
	private Staffs staffs;
	StaffsDAOImpl daoImpl = new StaffsDAOImpl();
	@Override
	public String execute() throws Exception {
		int id= Integer.parseInt(request.getParameter("id"));
		staffs = daoImpl.findById(id);
		try {
			boolean kq=daoImpl.delete(staffs);
			if(kq) {
				HttpSession session = request.getSession();				
				session.setAttribute("departs", staffs);
				return SUCCESS;	
			}
			addActionError("Lỗi xóa nhân viên");
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			 addActionError("Lỗi xóa nhân viên");
		 return ERROR;
		}
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
}
