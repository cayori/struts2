package resultRedirect.action;

import resultRedirect.dao.LoginDAO;
import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	String id;
	String pwd;
	
	public String getId()	{	return id;	}
	public String getPwd()	{	return pwd;	}
	public void setId(String id)	{	this.id = id;	}
	public void setPwd(String pwd)	{	this.pwd = pwd;	}
	
	public String execute() throws Exception {
		
		LoginDAO dao = new LoginDAO();
		if(dao.loginChk(id, pwd))	return SUCCESS;
		else						return LOGIN;
	}
}
