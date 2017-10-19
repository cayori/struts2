package srcPackage3;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String msg;
	
	public void validate() {
		if(name == null || "".equals(name)) {
			addFieldError("name", "ENTER YOUR NAME!!");
		}
	}
	public String getMsg() {
		return msg;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String execute() throws Exception{
		msg = "Hello, "+name;
		return SUCCESS;
	}
}
