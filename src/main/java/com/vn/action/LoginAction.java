package com.vn.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.vn.dao.UserDAO;
import com.vn.dao.UserDAOImpl;
import com.vn.entity.Users;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "login", //
		results = { //
				@Result(name = "input", location = "/WEB-INF/pages/login.jsp"), //
				@Result(name = "error", location = "/WEB-INF/pages/login.jsp"), //
				// loginSuccess: Redirect to /userInfo
				@Result(name = "success", type = "redirect", location = "/userInfo") //
		} //
)
public class LoginAction extends ActionSupport implements ServletRequestAware, SessionAware {

	Users user;
	UserDAO userDAO = new UserDAOImpl();

	private static final long serialVersionUID = 7299264265184515893L;
	private String username;
	private String password;

	private HttpServletRequest request;
	private Map<String, Object> session;

	@Override
	public String execute() {
		Users user = new Users();
		if (request.getMethod().equals("GET")) {
			return INPUT;
		} else {
			System.out.println("Hihi");
			
				user = userDAO.findByUserame(username);
			if(user.getUsername()==null) {
				addActionError("Mật khẩu không đúng");
				return ERROR;
			}
				
			if (user.getUsername() != null) {
				if ((user.getPassword()).equalsIgnoreCase(this.password)) {
					
					System.out.println("Dang nhap thanh cong");
					session.put("username", this.username);
					return SUCCESS;
				} else {
					addActionError("Mật khẩu không đúng");
					return ERROR;
				}
			} else {
				addActionError("Tài khoản hoặc mật khẩu không đúng");
				return ERROR;
			}
		}
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}