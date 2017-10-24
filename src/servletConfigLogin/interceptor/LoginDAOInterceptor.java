package servletConfigLogin.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import servletConfigLogin.dao.LoginDAO;
import servletConfigLogin.action.LoginAction;

public class LoginDAOInterceptor implements Interceptor{
	LoginDAO loginDAO;
	
	public void init() {
		loginDAO = new LoginDAO();
	}
	public void destroy() {
		loginDAO = null;
	}
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		if(action instanceof LoginAction) {
			LoginDAOAware loginDAOAware = (LoginDAOAware)action;
			loginDAOAware.setLoginDAO(loginDAO);
		}
		return invocation.invoke();
	}
}
