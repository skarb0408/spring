package xyz.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	// �Է��������� ���� ViewName�� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
	// ���ް��� ��ȯ�޾� ������������� �����ϰ� ����������� ���� ViewName�� ��ȯ�޴� �޼ҵ�
	//  => ���� ��û�� ���̱� ������ HttpServletRequest
	//  => POST ������� ��û�Ͽ� ���۵Ǵ� ��û ó�� �޼ҵ�
	@RequestMapping("/method_output")
	public String ouputOne(HttpServletRequest request) throws UnsupportedEncodingException {
		
		// Get ������� ��û�� ���
		if(request.getMethod().equals("get")) { 
			return "method_input1"; // �Է��������� ViewName ��ȯ
		}
		
		// HttpServletRequest.setCharacterEncoding(String encoding) : Post ������� ��û�Ͽ� ���޵� ���� ���� ĳ���ͼ� ����
		//  => �������� ���� ���ڵ� ������ UnsupportedEncodingException �߻� ����
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("name"); // �Է°� ����
		request.setAttribute("name", name); // scope ��ü�� �Է°� ����
		return "method_output1";
	}
	
	// ===================================================== �ٸ� ������� �غ���
	
	// �Է��������� ���� ViewName�� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	//  => get ������� ��û�Ͽ� ���۵Ǵ� ��û ó�� �޼ҵ�
	// method �Ӽ� : Ŭ���̾�Ʈ�� ��û����� �Ӽ������� ����
	//  => RequestMethod �ڷ���(Enum)�� ����� �Ӽ������� ���
	// Ŭ���̾�Ʈ�� ��û URL �ּҰ� ������ ��� ��û��Ŀ� ���� ��û ó�� �޼ҵ带 ���� �� ���
	//  => ��û��Ŀ� ���� @GetMapping, @PostMapping ���� ������̼����� ��û ó�� ����
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}
	
	// ������ ��û URL�� �ߺ��Ǹ� �ȵ����� �޼ҵ��� ��û����� �ٸ� ��� �ߺ� ������ �� �ִ�.
	
	// ���ް��� ��ȯ�޾� ������������� �����ϰ� ����������� ���� ViewName�� ��ȯ�޴� �޼ҵ�
	//  => post ������� ��û�Ͽ� ���۵Ǵ� ��û ó�� �޼ҵ�
	//  => get ��� ��û �Ұ���
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String ouputTWO(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("name"); // �Է°� ����
		request.setAttribute("name", name); // scope ��ü�� �Է°� ����
		return "method_output2";
	}
	
}
