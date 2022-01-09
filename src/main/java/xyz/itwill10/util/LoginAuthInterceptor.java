package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

// �α��� ���� ���� ó���� ���� ���ͼ���
//  => ��α��� ������� ��� ������������ �̵� ó��
public class LoginAuthInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session= request.getSession();
		
		if(session.getAttribute("loginUserinfo")==null) {
			throw new Exception();
		}
		
		return true;
		
	}
}
