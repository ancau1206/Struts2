package com.vn.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.vn.dao.DepartsDAOImpl;
import com.vn.entity.Departs;

@Action(value = "updateDeparts", results = {
		@Result(name = "input", location = "/WEB-INF/pages/departs/updateDeparts.jsp"),
		@Result(name = "error", location = "/WEB-INF/pages/departs/updateDeparts.jsp"),
		@Result(name = "success", type = "redirect", location = "/listDeparts") })
public class UpdateDeparts extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	private Departs departs;
	private String codeId2;
	private String name2;
	DepartsDAOImpl daoImpl = new DepartsDAOImpl();
 
	@Override
	public String execute() throws Exception {
		if (request.getMethod().equals("GET")) {
			int id= Integer.parseInt(request.getParameter("id"));
			departs = daoImpl.findById(id);
			return INPUT;
		} 
		 try {
		 boolean kq=daoImpl.update(departs);
		 if(kq) {
			 HttpSession session = request.getSession();
			 session.setAttribute("codeId", codeId2);
				session.setAttribute("name", name2);	
		 session.setAttribute("departs", departs);
		
		 return SUCCESS;
		 }
		 addActionError("Mã phòng ban đã tồn tại");
		 return ERROR;
		 } catch (Exception e) {
		 e.printStackTrace();
			 addActionError("Lỗi thêm phòng ban");
		 return ERROR;
		 }
	}
	
	public Departs getDeparts() {
		return departs;
	}

	public void setDeparts(Departs departs) {
		this.departs = departs;
	}


	public String getCodeId2() {
		return codeId2;
	}

	public void setCodeId(String codeId2) {
		this.codeId2 = codeId2;
	}

	public String getName2() {
		return name2;
	}

	public void setName(String name2) {
		this.name2 = name2;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
	
}
