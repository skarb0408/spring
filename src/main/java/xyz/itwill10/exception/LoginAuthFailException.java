package xyz.itwill10.exception;

// �α��ο� ���� ���� ������ ��츦 ���� �ۼ��� ���� Ŭ����
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
