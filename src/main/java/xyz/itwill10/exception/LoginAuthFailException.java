package xyz.itwill10.exception;

// 로그인에 대한 인증 실패할 경우를 위해 작성된 예외 클래스
public class LoginAuthFailException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String userid;
	
	public LoginAuthFailException() {
		
	}
	
	public LoginAuthFailException(String message, String userid) {
		super(message);
		this.userid= userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
