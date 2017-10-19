package srcPackage1;

public class HelloWorldAction {
	private String name;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String execute() throws Exception{
		msg = "Hello, "+name;
		return "success";
	}
}