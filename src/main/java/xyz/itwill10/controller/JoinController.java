package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill10.dto.Member;

@Controller
public class JoinController {
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	/*
	// �Ű������� �̸��� ���� �̸��� ���ް��� �����޾� �Ű������� ����
	// @RequestParam ������̼��� ����Ͽ� �Ű������� �̸��� ���� �̸��� ���ް��� ���� ��� 400 ���� �߻�
	//  => values �Ӽ��� �̿��Ͽ� �Ű������� �ٸ� �̸��� ���ް��� �����޾� �Ű������� ���� ����
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
				, @RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "join_display";
	}
	*/
	
	/*
	// @ModelAttribute ������̼��� �Ű������� ������ ��� �Ű������� ����� ���� ��û ó��
	// �޼ҵ��� ���������� �ڵ����� �������ش�.
	//  => �Ű������� �̸��� ���� �̸��� ���ް��� ��� 400 ���� �̹߻�
	//  => �Ű������� �ڷ����� �⺻��(Wrapper) �Ǵ� ������(String)�� ��� �ݵ�� value �Ӽ� �ݵ�� ����
	// value �Ӽ� : ������������ �Ű������� ����� ���� �����ϴ� �Ӽ����� �Ӽ������� ����
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute(value = "id") String id
				, @ModelAttribute("passwd") String passwd
				, @ModelAttribute("name") String name
				, @ModelAttribute("email") String email) {
		return "join_display";
	}
	*/
	
	/*
	// ��û ó�� �޼ҵ��� �Ű����� �ڷ����� JavaBean Ŭ������ ������ ��� JavaBean ��ü��
	// �����Ͽ� ���ް��� �ʵ忡 �ڵ����� ���� >> Command ��ü
	// Command ��ü : ���ް��� �ʵ忡 ����� ��ü�� �Ű������� �����ϰ� ���������� ����ϵ��� �����ϴ� ��ü
	//  => ���ް��� ������ �̸��� �ʵ忡 ����ȴ�.
	// ���������� Command ��ü�� ������������ ���� �ǵ��� @ModelAttribute ����Ѵ�.
	//  => @ModelAttribute ������̼��� �ۼ����� �ʾƵ� �ڵ� ó��
	//  => value �Ӽ��� ������ ��� Ŭ�������� �Ӽ������� �ڵ� ����
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_display";
	}
	*/
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
		if(member.getId().equals("abc123")) { // ���̵� �ߺ��� ���
			model.addAttribute("message", "�̹� ������� ���̵��Դϴ�.");
			return "join_form";
		}
		return "join_display";
	}
}
