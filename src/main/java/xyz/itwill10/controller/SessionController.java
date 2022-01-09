package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import xyz.itwill10.dto.Hewon;

@Controller

// @SessionAttributes : ��Ʈ�ѷ� ��û ó�� �޼ҵ��� ������������ �����Ǵ� ��ü�� ���� ��Ʈ�ѷ��� ���
// ��û ó�� �޼ҵ�� ������������ ����� �� �ֵ��� �����ϴ� ������̼�
//  => Model ��ü�� �̿��Ͽ� ��ü�� ������ ��� Request Scope�� �ƴ� Session Scope!
//  => Session Scope�� ��������� ���� ��Ʈ�ѷ��� �ڿ��� ��� ����
//  => ���� ó���� �ٸ� ��û ó�� �޼ҵ忡�� �ʿ��� ������ �����ϰų� �˻��ϴ� �۾� ����
//  => ���� ��������� ���� ��
// value �Ӽ� : Session Scope�� �����ϱ� ���� �Ӽ����� �Ӽ������� ���� >> �ʼ�
//  => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
@SessionAttributes("hewon")
public class SessionController {
	
	private Hewon getHewon(String id) {
		// ���̵� ���޹޾� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ� >> Service Ŭ������ �޼ҵ�
		Hewon hewon= new Hewon();
		hewon.setId("abc123");
		hewon.setPassword("123456");
		hewon.setName("ȫ�浿");
		hewon.setEmail("abc123@abc.com");
		hewon.setGender("����");
		return hewon;
	}
	
	// ���̵� ���޹޾� ȸ�������� �˻��Ͽ� ���������� �����ϴ� ��û ó�� �޼ҵ�
	@RequestMapping("/hewon_view")
	public String hewonView(Model model) {
		// ȸ�������� �˻��Ͽ� ��ȯ�޾� ���� >> Serivce Ŭ���� �޼ҵ� ȣ��
		Hewon hewon= getHewon("abc123");
		
		// Model ��ü�� �̿��Ͽ� ���������� �˻�ȸ�� ���� >> Request Scope
		//model.addAttribute("hewon", hewon);
		
		// Model.addAttribute(Object attributeValue) : �� �������� �����Ǵ� ��ü�� �Ӽ���(AttributeName)��  ������ ���
		// ��ü(�Ӽ���)�� Ŭ�������� �Ӽ������� �ڵ� ���� >> ù��° ���ڴ� �ҹ��ڷ� ��ȯ
		//  => �⺻��(Wrapper) �Ǵ� String Ŭ������ ����
		// @SessionAttributes ������̼ǿ� ���� ���� ��Ʈ�ѷ��� ��� ��û ó�� �޼ҵ�� ���������� ���ǵ��� �����ȴ�. >> Session Scope
		model.addAttribute(hewon);
		return "session/hewon_view";
	}
	
	/*
	// ���̵� ���޹޾� ȸ�������� �˻��Ͽ� ���������� �����ϴ� ��û ó�� �޼ҵ�
	//  => ������ �Ϸ��� ��¥�� ���� �޾ƿ;��Ѵ�.
	//  => ȸ�������� �������� ������������ �Է��±׿� ȸ�������� �ʱⰪ���� ����(form �±� �ȿ�)
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate(@RequestParam String id, Model model) {
		Hewon hewon= getHewon(id);
		model.addAttribute(hewon);
		return "session/hewon_update";
	}
	*/
	
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate(Model model) {
		// Session Scope �� �̿��Ͽ� �Ƚᵵ��
		return "session/hewon_update";
	}
	
	
	
	// ȸ�������� ���޹޾� ȸ�������� �����ϴ� ��û ó�� �޼ҵ�
	// @SessionAttributes ������̼ǿ� ���� ������ ��ü�� �Ű������� �����ϰ� ���ް��� �޾� �ʵ尪�� �����Ѵ�.
	// SessionStatus : @SessionAttributes ������̼ǿ� ���� ������ ��ü�� ���������� �����ϴ� �������̽�
	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String hewonUpdate(@ModelAttribute Hewon hewon, SessionStatus status ) {
		
		System.out.println("���̵� = " + hewon.getId());
		
		// SessionStatus.setComplete() : @SessionStatus ������̼ǿ� ���� ������ ��ü�� �����ϴ� �޼ҵ�
		status.setComplete();
		
		return "session/hewon_view";
	}
}
