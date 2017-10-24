package resultChain.action;

import resultChain.model.UserInfo;
import resultChain.dao.LoginDAO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements Action, Preparable, ModelDriven<UserInfo> {
	UserInfo userInfo;
	
//	public UserInfo getUserInfo() {
//		return userInfo;
//	}

	@Override
	public UserInfo getModel() {
		return userInfo;
	}

	@Override
	public void prepare() throws Exception {
		userInfo = new UserInfo();
	}

	@Override
	public String execute() throws Exception {
		LoginDAO dao = new LoginDAO();
		if(dao.loginChk(userInfo))	return SUCCESS;
		else						return LOGIN;		
	}
	
}
