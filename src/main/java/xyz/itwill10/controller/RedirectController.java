package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_print") // ��û
	public String forward(Model model) {
		// ���������� ����� ��ü ���� >> Request Scope
		model.addAttribute("name", "ȫ�浿");
		
		// ViewName ��ȯ >> ��������(JSP)�� ������ �̵�
		// ������ �̵� : ���������� �ٸ� �����α׷�(JSP)���� �����带 �̵��Ͽ� ���� ó��
		//  => Ŭ���̾�Ʈ�� URL �ּ� �̺���(Ŭ���̾�Ʈ ���x), Request Scope�� �����Ǵ� ��ü ���
		return "movement/forward_display"; // ��ȯ
	}
	
	/*
	@RequestMapping("redirect_print")
	public String redirect(Model model) {
		model.addAttribute("name", "�Ӳ���");
		return "movement/redirect_display";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		// ��ȯ�Ǵ�  ViewName�� redirect ���λ�(NameSpace)�� ����ϸ� �����̷�Ʈ �̵�
		//  => ViewName�� ���� ��������(JSP)�� �����ϴ� ��� Ŭ���̾�Ʈ���� URL �ּ� ����
		// �����̷�Ʈ �̵� : Ŭ���̾�Ʈ���� URL �ּҸ� �����Ͽ� ���û�Ͽ� ���� ó��
		//  => Ŭ���̾�Ʈ�� ��û URL �ּ� ����, Request Scope�� �����Ǵ� ��ü ��� �Ұ���
		return "redirect:/redirect_print"; // : ??
	}
	*/
	
	@RequestMapping("redirect_print")
	public String redirect() {
		
		return "movement/redirect_display";
	}
	
	/*
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		model.addAttribute("name", "�Ӳ���");
		return "redirect:/redirect_print"; // : ??
	}
	*/
	
	// RedirectAttributes : �����̷�Ʈ �̵��� ���� ȣ��Ǵ� ��û ó�� �޼ҵ��� ������������ �Ӽ����� �����ϱ� ���� ��ü
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		// Model�� �̿��� ��� ���� �ȵ�
		//model.addAttribute("name", "�Ӳ���");
		// RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		//  => �����̷�Ʈ �̵��� ���� ȣ��Ǵ� ��û ó�� �޼ҵ��� ������������ ������ �Ӽ����� �����ϴ� �޼ҵ�
		attributes.addFlashAttribute("name", "�Ӳ���");
		return "redirect:/redirect_print"; // : ??
	}
}
