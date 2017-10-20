package login2.action;

import login2.model.UserInfo;
import login2.dao.LoginDAO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class LoginAction implements Action, ModelDriven, Preparable {
	// 도메인 오브젝트
	UserInfo userInfo;
	
	@Override
	public void prepare() throws Exception {
		userInfo = new UserInfo();		
	}

	@Override
	public Object getModel() {
		return userInfo;
	}

	@Override
	public String execute() throws Exception {
		LoginDAO dao = new LoginDAO();
		if(dao.loginChk(userInfo)) {
			return SUCCESS;
		}else {
			return LOGIN;
		}		
	}	
}
