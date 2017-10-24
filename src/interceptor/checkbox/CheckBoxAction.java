package interceptor.checkbox;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import interceptor.checkbox.UserModel;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class CheckBoxAction implements Action, Preparable, ModelDriven<UserModel> {
	UserModel user;
	Log log = LogFactory.getLog(CheckBoxAction.class);
	
	public String execute() throws Exception {
		log.info(">>>> male   : "+user.getMale());
		log.info(">>>> female : "+user.getFemale());
		return SUCCESS;
	}
	public void prepare() 		{	user = new UserModel();	}
	public UserModel getModel()	{	return user;	}
}
