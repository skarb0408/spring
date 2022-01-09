package xyz.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Member;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login_form";
	}
	/*
	// ��û ó�� �޼ҵ忡 HttpSession Ŭ������ �ڷ������� �ϴ� �Ű������� �����ϸ� 
	// ���� ���ε��Ͽ� HttpSession ��ü�� �Ű������� �����Ͽ� ����
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String passwd
			, Model model, HttpSession session) {
		if(id.equals("abc123") || passwd.equals("123456")) { // ���� ����
			// Request Scope : ��û ó�� �޼ҵ�� ��������(JSP)������ ��� ����
			model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ ������");
			model.addAttribute("id", id);
			return "session/login_form"; // ���⼭�ۿ� ����
		}
		
		// Session scope : ��� ��û ó�� �޼ҵ�� ������������ �Ӽ��� ��� ����
		session.setAttribute("loginId", id);
		return "session/login_result";
	}
	*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Member member, Model model, HttpSession session ) {
		if(member.getId().equals("abc123") || member.getPasswd().equals("123456")) { // ���� ����
			model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ ������");
			return "session/login_form"; // ���⼭�ۿ� ����
		}
		
		session.setAttribute("loginId", member.getId());
		return "session/login_result";
	}
}
