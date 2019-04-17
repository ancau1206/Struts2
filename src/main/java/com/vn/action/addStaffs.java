package com.vn.action;



import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vn.dao.DepartsDAOImpl;
import com.vn.dao.StaffsDAO;
import com.vn.dao.StaffsDAOImpl;
import com.vn.entity.Departs;
import com.vn.entity.Staffs;

@Action(value = "addStaffs", results = { @Result(name = "input", location = "/WEB-INF/pages/staffs/addStaffs.jsp"),
		@Result(name = "error", location = "/WEB-INF/pages/staffs/addStaffs.jsp"),
		@Result(name = "success", type = "redirect", location = "/listStaffs" ) })
public class addStaffs extends ActionSupport implements ServletRequestAware{
Staffs staffs;
StaffsDAO staffsDao= new StaffsDAOImpl();
private static final long serialVersionUID = 1L;

private String codeId;
	private String name;
	private boolean gender;
	private String photo;
	private String email;
	private byte level;
	private Collection<Departs> listDeparts;
	DepartsDAOImpl departsDAOImpl = new DepartsDAOImpl();
	private Departs departs;
	
	StaffsDAOImpl daoStaffsImpl = new StaffsDAOImpl();
	private HttpServletRequest request;
	
	
	@Override
	public String execute() throws Exception {
		if (request.getMethod().equals("GET")) {
			listDeparts = departsDAOImpl.getAll();
			return INPUT;
		}
 		try{
			Staffs staffs= new Staffs(departs,getCodeId(),getName(),isGender(),getPhoto(),getEmail(),getLevel());
			boolean kq=staffsDao.create(staffs);
			if(kq) {
				HttpSession session = request.getSession();
				session.setAttribute("codeId", codeId);
				session.setAttribute("name", name);
				session.setAttribute("email", email);
				session.setAttribute("photo", photo);
				session.setAttribute("staffs", staffs);
				return SUCCESS;
			}
			else{
				addActionError("Mã nhân viên đã tồn tại");
			    return ERROR;
			}
		} catch (Exception e) {
			addActionError("Lỗi thêm nhân viên");
			return ERROR;
		}
	}
	public Collection<Departs> getListDeparts() {
		return departsDAOImpl.getAll();
	}
	public Departs getDeparts() {
		return departs;
	}

	public void setDeparts(Departs departs) {
		this.departs = departs;
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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
		
	}
}
