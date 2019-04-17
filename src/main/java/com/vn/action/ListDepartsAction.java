package com.vn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vn.dao.DepartsDAO;
import com.vn.dao.DepartsDAOImpl;
import com.vn.entity.Departs;
@Action(value = "listDeparts", results = { @Result(name = "input", location = "/WEB-INF/pages/departs/listDeparts.jsp"),
		})
public class ListDepartsAction extends ActionSupport implements ServletRequestAware  {
	List<Departs> departs;
     DepartsDAO departsDao=new DepartsDAOImpl();
	/**
	 * 
	 */
   
 	private static final long serialVersionUID = 1L;
 	  private String codeId;
 	  private String name;
 	 private HttpServletRequest request;
	@Override
    public String execute() throws Exception {
	departs=departsDao.getAll(); 
        HttpSession session = request.getSession();
		session.setAttribute("departs", departs);
		return "input";
      
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
