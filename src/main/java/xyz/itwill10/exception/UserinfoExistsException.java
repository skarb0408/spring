package xyz.itwill10.exception;

import xyz.itwill10.dto.Userinfo;

// 회원 등록시 사용자가 입력한 아이디가 이미 존재하는 경우를 대비하여 작성된 예외 클래스
public class UserinfoExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	// 예외처리시 필요한 값을 저장하기 위한 필드 >> 뭘 저장?
	//  => 사용자가 입력한 회원정보를 저장하기 위한 필드
	private Userinfo userinfo;
	
	public UserinfoExistsException() {
		// TODO Auto-generated constructor stub
	}
	
	// 예외 발생시 예외 발생 메시지와 입력정보 전달을 위한 생성자
	 public UserinfoExistsException(String message, Userinfo userinfo) {
		 super(message);
		 this.userinfo= userinfo;
	 }

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	 
	 
}
