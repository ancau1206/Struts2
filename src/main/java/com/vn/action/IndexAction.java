package com.vn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vn.dao.RecordsDAO;
import com.vn.dao.RecordsImpl;

@Action(value = "index", results = { @Result(name = "input", location = "/WEB-INF/pages/home/index.jsp"),
})
public class IndexAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	List<Object[]> list;
	RecordsImpl daoImpl=new RecordsImpl();
	HttpServletRequest request;
	@Override
    public String execute() throws Exception {
	list=daoImpl.getTop10Records(); 
        HttpSession session = request.getSession();
		session.setAttribute("list", list);
		return "input";
      
    }
	@Override
	public void setServletRequest(HttpServletRequest request) {
	this.request=request;
		
	}

}
