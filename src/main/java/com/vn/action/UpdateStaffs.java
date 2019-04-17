package com.vn.action;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vn.dao.DepartsDAOImpl;
import com.vn.dao.StaffsDAOImpl;
import com.vn.entity.Departs;
import com.vn.entity.Staffs;

@Action(value = "updateStaffs", results = {
		@Result(name = "input", location = "/WEB-INF/pages/staffs/updateStaffs.jsp"),
		@Result(name = "error", location = "/WEB-INF/pages/staffs/updateStaffs.jsp"),
		@Result(name = "success", type = "redirect", location = "/listStaffs") })
public class UpdateStaffs extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	Staffs staffs;
	private DepartsDAOImpl departsDAOImpl = new DepartsDAOImpl();

	StaffsDAOImpl daoImpl = new StaffsDAOImpl();
	private String codeId;
	private String name;
	private String email;
	private String photo;
	private Collection<Departs> listDeparts;

	@Override
	public String execute() throws Exception {
		if (request.getMethod().equals("GET")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			listDeparts = departsDAOImpl.getAll();
			staffs = daoImpl.findById(id);
			return INPUT;
		}
		try {
			boolean kq = daoImpl.update(staffs);
			if (kq) {
				HttpSession session = request.getSession();
				session.setAttribute("staffs.codeId", codeId);
				session.setAttribute("staffs.name", name);
				session.setAttribute("staffs.email", email);
				session.setAttribute("staffs.photo", photo);
				session.setAttribute("staffs", staffs);
				return SUCCESS;
			}
			else{
				addActionError("Mã nhân viên đã tồn tại");
				return ERROR; 		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Cập nhật nhân viên thất bại");
			return ERROR;
		}
	}

	public Collection<Departs> getListDeparts() {
		return departsDAOImpl.getAll();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Staffs getStaffs() {
		return staffs;
	}

	public void setStaffs(Staffs staffs) {
		this.staffs = staffs;
	}

   
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

}
