package upload.interceptor;

import upload.dao.FileUploadDAO;

// 아래 인터페이스를 구현한 액션은 FileUploadDAO 빈을 주입가능
public interface FileUploadDAOAware {
	public void setFileUploadDAO(FileUploadDAO fileUploadDAO);
}
