package xyz.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice : 예외처리 메소드만 선언된 Controller 클래스에서 사용하는 어노테이션
//  => 모든 컨트롤러의 요청 처리 메소드에서 발생되는 예외에 대한 처리 가능 => 아예 500 안뜸(권장 안함)
@ControllerAdvice // => 모!! 든!! 컨트롤러
public class ExceptionController {
	/*
	@ExceptionHandler(Exception.class)
	public String exceptionHander() {
		return "userinfo/user_error";
	}
	나중에 하는 것을 권장 >> 다 만들고 난 후 하세염
	왜? 만드는 동안 에러 메시지가 다 안보임
	
	@ExceptionHandler(Exception.class)
	public String exceptionHander(Exception exception) {
		exception.printStackTrace(); // 예외를 콘솔에 기록
		return "userinfo/user_error";
	}
	*/
}
