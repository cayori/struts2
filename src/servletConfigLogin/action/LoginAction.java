package servletConfigLogin.action;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import servletConfigLogin.dao.LoginDAO;
import servletConfigLogin.interceptor.LoginDAOAware;
import servletConfigLogin.model.UserInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.NoParameters;

public class LoginAction implements Action, Preparable, ModelDriven<UserInfo>, LoginDAOAware, SessionAware, ServletRequestAware, RequestAware {
	// domain object
	UserInfo userInfo;
	LoginDAO dao;
	Map sessionMap;
	Map requestMap;
	HttpServletRequest request;
	Log log = LogFactory.getLog(LoginAction.class);
	
	public String execute() throws Exception {
		//LoginDAO dao = new LoginDAO; ==>> 인젝션 할거라서 뺌
		if(dao.loginChk(userInfo)) {
			sessionMap.put("userInfo", userInfo);
			log.info(">>>>> request URI : "+request.getRequestURI());
			log.info(">>>>> request ID  : "+requestMap.get("id".toString()));
			log.info(">>>>> request PWD : "+requestMap.get("pwd").toString());
			return SUCCESS;
		}else {
			return LOGIN;
		}
	}
	
	//Preparable 구현
	public void prepare() {
		userInfo = new UserInfo();
	}
	//ModelDriven 구현
	public UserInfo getModel() {
		return userInfo;
	}
	//LoginDAOAware 구현
	public void setLoginDAO(LoginDAO loginDAO) {
		this.dao = loginDAO;
	}
	//SessionAware 구현
	public void setSession(Map session) {
		this.sessionMap = session;
	}
	//ServletRequestAware 구현 
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	//RequestAware 구현
	public void setRequest(Map requestMap) {
		this.requestMap = requestMap;
	}
	
}













