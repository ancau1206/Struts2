package com.vn.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.vn.dao.DepartsDAO;
import com.vn.dao.DepartsDAOImpl;
import com.vn.entity.Departs;

@Action(value = "addDeparts", results = { @Result(name = "input", location = "/WEB-INF/pages/departs/addDeparts.jsp"),
		@Result(name = "error", location = "/WEB-INF/pages/departs/addDeparts.jsp"),
		@Result(name = "success", type = "redirect", location = "/listDeparts" ) })
public class AddDeparts extends ActionSupport implements ServletRequestAware{
     Departs departs;
     DepartsDAO departsDao= new DepartsDAOImpl();
     
     private static final long serialVersionUID = 1L;
 	private String codeId;
 	private String name;
 	
 	private HttpServletRequest request;

 	@Override
	public String execute() throws Exception {
 		if (request.getMethod().equals("GET")) {
			return INPUT;
		}
 		try {
			Departs departs= new Departs(codeId, name);
			boolean kq=departsDao.create(departs);
			if(kq) {
				HttpSession session = request.getSession();
				session.setAttribute("codeId", codeId);
				session.setAttribute("name", name);
				session.setAttribute("departs", departs);
				return SUCCESS;
			}
			addActionError("Mã phòng ban đã tồn tại");
			return ERROR;
		} catch (Exception e) {
			addActionError("Lỗi thêm phòng ban");
			return ERROR;
		}
 	}
 	
	public String getCodeId() {
		return codeId;
	}
 	
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
     
}
