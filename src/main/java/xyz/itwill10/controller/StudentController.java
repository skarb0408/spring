package xyz.itwill10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

// Controller Ŭ���� : Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� ����� �����ϴ� Ŭ����
//  => ��û ó�� �޼ҵ忡���� Service Ŭ������ �޼ҵ带 ȣ���Ͽ� ��û ó��

// @Controller : Controller Ŭ������ Spring Bean���� ����ϴ� ������̼�'
//  => Ŭ���̾�Ʈ ��û�� ���� ó�� ����� �����޾� ���
// Spring Container�� Spring ������̼��� ó���ϱ� ���� Bean configuratiom File(servlet-context.xml)
// component-scan ������Ʈ�� ����Ͽ� Controller Ŭ������ �ۼ��� ��Ű�� ����
@Controller
// @RequestMapping Ŭ������ ������ ��� ��� ��û ó�� �޼ҵ� ��û URL �ּ� �� �κп�
// ���������� ���ԵǴ� ���ڿ� ������ �����ϴ�.
@RequestMapping("/student")
public class StudentController {
	// Service Ŭ������ ��ϵ� Spring Bean ��ü�� �ʵ忡 ������ ó��
	//  => ��ûó�� �޼ҵ忡�� Service Ŭ������ �޼ҵ忡�� DAO ��ü�� �޼ҵ� ȣ�� ���� >> Service >> DAO
	@Autowired
	private StudentService studentService;
	
	// student/add �� get ������� ��û���� ���
	//@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "student/add_student";
	}
	
	//@RequestMapping(value ="/student/add", method = RequestMethod.POST)
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
			// PK ���������� ������ �÷��� �ߺ��� ���� ���޵� ��� ���� �߻�
			studentService.addStudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "�̹� ������� �й��� �Է��ϼ̽��ϴ�.");
			return "student/add_student";
		}
		return "redirect:/student/display";
	}
	
	//@RequestMapping("/student/display")
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/display_student";
	}
	
}
