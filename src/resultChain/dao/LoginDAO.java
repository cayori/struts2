package resultChain.dao;

import resultChain.model.UserInfo;

public class LoginDAO {
	public boolean loginChk(UserInfo userInfo) {
		if(userInfo.getId() != null && "test".equals(userInfo.getId())) {
			return true;
		}else {
			return false;
		}
	}
}
