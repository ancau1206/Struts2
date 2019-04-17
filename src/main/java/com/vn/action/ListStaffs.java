package com.vn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vn.dao.StaffsDAO;
import com.vn.dao.StaffsDAOImpl;
import com.vn.entity.Staffs;

@Action(value = "listStaffs", results = { @Result(name = "input", location = "/WEB-INF/pages/staffs/listStaffs.jsp"),
})
public class ListStaffs extends ActionSupport implements ServletRequestAware {
List<Staffs> staffs;
StaffsDAO staffsDao=new StaffsDAOImpl();
private static final long serialVersionUID = 1L;
private HttpServletRequest request;
@Override
public String execute() throws Exception {
staffs=staffsDao.getAll(); 
    HttpSession session = request.getSession();
	session.setAttribute("staffs", staffs);
	return "input";
  
}
@Override
public void setServletRequest(HttpServletRequest request) {
	this.request = request;
	
}
}
