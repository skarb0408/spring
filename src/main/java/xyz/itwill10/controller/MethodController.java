package xyz.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	// 입력페이지에 대한 ViewName을 반환하는 요청 처리 메소드
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
	// 전달값을 반환받아 출력페이지에게 제공하고 출력페이지에 대한 ViewName을 반환받는 메소드
	//  => 값을 요청할 것이기 때문에 HttpServletRequest
	//  => POST 방식으로 요청하여 동작되는 요청 처리 메소드
	@RequestMapping("/method_output")
	public String ouputOne(HttpServletRequest request) throws UnsupportedEncodingException {
		
		// Get 방식으로 요청한 경우
		if(request.getMethod().equals("get")) { 
			return "method_input1"; // 입력페이지의 ViewName 반환
		}
		
		// HttpServletRequest.setCharacterEncoding(String encoding) : Post 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
		//  => 지원되지 않은 인코딩 설정시 UnsupportedEncodingException 발생 가능
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("name"); // 입력값 저장
		request.setAttribute("name", name); // scope 객체에 입력값 저장
		return "method_output1";
	}
	
	// ===================================================== 다른 방식으로 해보기
	
	// 입력페이지에 대한 ViewName을 반환하는 요청 처리 메소드
	//  => get 방식으로 요청하여 동작되는 요청 처리 메소드
	// method 속성 : 클라이언트의 요청방식을 속성값으로 설정
	//  => RequestMethod 자료형(Enum)의 상수를 속성값으로 사용
	// 클라이언트의 요청 URL 주소가 동일한 경우 요청방식에 의해 요청 처리 메소드를 구분 후 출력
	//  => 요청방식에 따라 @GetMapping, @PostMapping 등의 어노테이션으로 요청 처리 가능
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}
	
	// 원래는 요청 URL이 중복되면 안되지만 메소드의 요청방식이 다를 경우 중복 선언할 수 있다.
	
	// 전달값을 반환받아 출력페이지에게 제공하고 출력페이지에 대한 ViewName을 반환받는 메소드
	//  => post 방식으로 요청하여 동작되는 요청 처리 메소드
	//  => get 방식 요청 불가능
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String ouputTWO(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("name"); // 입력값 저장
		request.setAttribute("name", name); // scope 객체에 입력값 저장
		return "method_output2";
	}
	
}
