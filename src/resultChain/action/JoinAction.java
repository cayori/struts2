package resultChain.action;

import resultChain.model.UserInfo;
import resultChain.dao.JoinDAO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

public class JoinAction implements Action, Preparable, ModelDriven<UserInfo> {
	UserInfo userInfo;
	
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
		JoinDAO dao = new JoinDAO();
		if(dao.join(userInfo))		return SUCCESS;
		else						return LOGIN;		
	}

}
