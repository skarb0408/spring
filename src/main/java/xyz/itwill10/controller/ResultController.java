package xyz.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// ��û ó�� �޼ҵ��� ó������� ��������(JSP)�� �����ϴ� ���
// 1. ModelAndView ��ü�� ó������� �Ӽ������� �����Ͽ� ����
//  => ��û ó�� �޼ҵ�� �ݵ�� ModelAndView ��ü ��ȯ
// 2. HttpServletRequest ��ü�� ó������� �Ӽ������� �����Ͽ� ���� >> �ܼ��ϰ� �Ӽ��� ��������� ���⿡�� �ʹ� ���� ������ ����ִ� >> ó�� ����� ������

// 3. Model ��ü�� ó������� �Ӽ������� �����Ͽ� ���� >> ���� ���������� ���� ��

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView= new ModelAndView("result_display"); // ViewName ����
		// ModelAndView.addObject(String attribute, Object attributeValue)
		//  => ������������ ��� �����ϵ��� ó�����(��ü)�� �����ϴ� �޼ҵ� >> Request Scope
		modelAndView.addObject("mavName", "ȫ�浿"); // ��� ����
		return modelAndView; // ��ȯ
	}
	*/
	
	// ��û ó�� �޼ҵ�� Front Controller�� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	//  => ��û ó�� �޼ҵ忡 �Ű������� �ۼ��ϸ� Spring Container�κ��� Spring Bean ��ü�� 
	//			�����޾� �Ű������� �ڵ����� ����
	//  => Spring Container�� �����ϴ� ����
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "ȫ�浿");
		return modelAndView;
	}
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		request.setAttribute("requestName", "�Ӳ���");
		return "result_display";
	}
	
	// Model : ó������� �����ϱ� ���� ��ü(ModelMap ��ü) >> ModelAndView �� Model��
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		// Model.addAttribute(String attributeName, Object attributeValue)
		//  => ������������ ��� �����ϵ��� ó�����(��ü)�� �����ϴ� �޼ҵ� >> Request Scope
		model.addAttribute("modelName", "����ġ");
		return "result_display";
	}
}
