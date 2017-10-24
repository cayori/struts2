package servletConfigLogin.dao;

import servletConfigLogin.model.UserInfo;

public class LoginDAO {
	public boolean loginChk(UserInfo userInfo) {
		//DB 연결 후 넘어오는 사용자 정보를 가지고 로그인 체크
		//본 예제에서는 id 가 test 이면 로그인 성공으로 간주
		//UserInfo 의 name 에 "홍길동" 으로 세팅 후 true 를 리턴
		if("test".equals(userInfo.getId())) {
			userInfo.setName("홍길동");
			return true;
		}else {
			return false;
		}
	}
}
