package xyz.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice : ����ó�� �޼ҵ常 ����� Controller Ŭ�������� ����ϴ� ������̼�
//  => ��� ��Ʈ�ѷ��� ��û ó�� �޼ҵ忡�� �߻��Ǵ� ���ܿ� ���� ó�� ���� => �ƿ� 500 �ȶ�(���� ����)
@ControllerAdvice // => ��!! ��!! ��Ʈ�ѷ�
public class ExceptionController {
	/*
	@ExceptionHandler(Exception.class)
	public String exceptionHander() {
		return "userinfo/user_error";
	}
	���߿� �ϴ� ���� ���� >> �� ����� �� �� �ϼ���
	��? ����� ���� ���� �޽����� �� �Ⱥ���
	
	@ExceptionHandler(Exception.class)
	public String exceptionHander(Exception exception) {
		exception.printStackTrace(); // ���ܸ� �ֿܼ� ���
		return "userinfo/user_error";
	}
	*/
}
