package srcPackage2;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action{
	private String name;
	private String msg;
	private String retMsg;
	
	public String getMsg() {
		return msg;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public String execute() throws Exception{
		//validation check
		if(name == null || "".equals(name)) {
			retMsg = "ENTER NAME!!";
			return INPUT;
		}
		msg = "Hello, "+name;
		return SUCCESS;
	}
}
