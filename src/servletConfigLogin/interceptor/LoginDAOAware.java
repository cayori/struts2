package servletConfigLogin.interceptor;

import servletConfigLogin.dao.LoginDAO;

public interface LoginDAOAware {
	public void setLoginDAO(LoginDAO loginDAO);
}
