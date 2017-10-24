package resultStream;

import java.io.FileInputStream;
import java.io.InputStream;
import com.opensymphony.xwork2.Action;

public class FileDownloadAction implements Action {
	String dir;					// struts.xml 에서 넘어오는 값으로 세팅
	String fileName;			// 요청파라미터 이름과 일치할 것
	InputStream inputStream;	// 이 변수명은 struts.xml 의 <param name="inputName"> 으로 정의됨
	
	public String execute() throws Exception {
		inputStream = new FileInputStream(dir+"/"+fileName);
		return SUCCESS;
	}
	
	public void setDir(String dir)				{	this.dir = dir;	}
	public void setFileName(String fileName)	{	this.fileName = fileName;	}
	
	public InputStream getInputStream()			{	return inputStream;	}
	public String getFileName()					{	return fileName;	}
}
