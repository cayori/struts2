package upload.action;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import upload.dao.FileUploadDAO;
import upload.interceptor.FileUploadDAOAware;
import upload.model.UserInfo;

public class FileUploadAction extends ActionSupport implements Preparable, ModelDriven<UserInfo>, FileUploadDAOAware {
	private static final long serialVersionUID = 1L;
	// 실제 파일저장 디렉토리 지정
	private final String UPLOAD_DIR = "C:/upload/";
	private Log log = LogFactory.getLog(FileUploadAction.class);
	
	// ---- fileUpload 인터셉터가 설정하는 부분
	// ---- setter 가 만들어져 있어야 한다.
	
	// fileUpload 인터셉터가 임시 디렉토리에 저장한 파일객체
	File doc;
	// Content Type
	String docContentType;
	// source filename
	String docFileName;
	
	// ----
	// ----
	
	// domain object
	UserInfo userInfo;
	// 실제 업로드 디렉토리에 보관될 파일객체
	File savedFile;
	// FileUploadDAO 참조
	FileUploadDAO fileUploadDAO;
	
	public String execute() throws Exception {
		// fileUploadDAO 의 insert 메소드 호출
		if(fileUploadDAO.insertUserInfo(userInfo)) {
			log.info(" >>>>>> fileUploadDAO.insertUserInfo 후...");
			// fileUpload 인터셉터가 임시디렉토리에 저장한 파일을 실제 업로드 폴더로 복사
			// 임시 디렉토리 파일은 액션 종료 후 fileUpload 인터셉터가 삭제한다.
			if(doc != null && doc.exists()) {
				log.info(" >>>>>> FileCopy 전...");
				savedFile = new File(UPLOAD_DIR + docFileName);
				FileUtils.copyFile(doc,savedFile);
				log.info(" >>>>>> FileCopy 후...");
			}
		}
		return SUCCESS;
	}
	
	
	// setter 설정
	public void setDoc(File doc) {
		this.doc = doc;
	}
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	
	// FileUploadDAOInterceptor 에서 FileUploadDAO 를 주입한다 (DI)
	public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
		this.fileUploadDAO = fileUploadDAO;
	}
	
	// getter 설정
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public File getDoc() {
		return this.doc;
	}
	public File getSavedFile() {
		return this.savedFile;
	}
	
	// Preparable 인터페이스 구현
	public void prepare() throws Exception{
		userInfo = new UserInfo();
	}
	// ModelDriven 인터페이스 구현
	public UserInfo getModel() {
		return userInfo;
	}
	
}
