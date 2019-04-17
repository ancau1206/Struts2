package com.vn.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vn.dao.DepartsDAOImpl;
import com.vn.entity.Departs;

@Action(value = "deleteDeparts", results = {
		@Result(name = "error", location = "/WEB-INF/pages/departs/listDeparts.jsp"),
		@Result(name = "success", type = "redirect", location = "/listDeparts") })
public class DeleteDeparts extends ActionSupport implements ServletRequestAware{
	HttpServletRequest request;
	private static final long serialVersionUID = 1L;
	private Departs departs;
	DepartsDAOImpl daoImpl = new DepartsDAOImpl();
	@Override
	public String execute() throws Exception {
		int id= Integer.parseInt(request.getParameter("id"));
		departs = daoImpl.findById(id);
		try {
			boolean kq=daoImpl.delete(departs);
			if(kq) {
				HttpSession session = request.getSession();				
				session.setAttribute("departs", departs);
				return SUCCESS;	
			}
			addActionError("Lỗi xóa phòng ban");
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			 addActionError("Lỗi thêm phòng ban");
		 return ERROR;
		}
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

}
