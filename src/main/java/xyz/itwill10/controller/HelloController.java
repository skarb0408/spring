package xyz.itwill10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// ��û ó�� Ŭ����
// @Controller : Ŭ���̾�Ʈ�� ��û�� ó���ϴ� Controller Ŭ������ Spring Bean���� ����ϴ� ������̼�
//  => �⺻������ Ŭ�������� beanName���� ���(ī�� ǥ���) >> value �Ӽ����� ���氡��
//  => Controller �������̽��� ��ӹ��� �ʾƵ� Controller Ŭ������ �ۼ� ����
//  => Ŭ���̾�Ʈ�� ��û�� ó���ϴ� �ټ��� ��û ó�� �޼ҵ� �ۼ� ���� >> @RequestMapping ������̼�
@Controller
public class HelloController {
	private static final Logger logger= LoggerFactory.getLogger(HelloController.class);
	
	// ��û ó�� �޼ҵ忡�� Front Controller(DispatchServlet)���� ViewName�� ��ȯ�ϴ� ���
	//  => Front Controller�� ���޹��� ViewName�� �����޾� ViewResolver Ŭ�������� �����Ͽ� JSP ����
	//  ��ġ�� ��ȯ�޾� ������ �̵��Ͽ� ���� ó��
	// 1. ��û ó�� �޼ҵ��� ��ȯ���� void�� �ۼ��ϸ� �޼ҵ���� viewName���� �����Ѵ�.
	// 2. ��û ó�� �޼ҵ��� ��ȯ���� String�� �ۼ��ϸ� ��ȯ�Ǵ� ���ڿ��� viewName���� �����Ѵ�. >> ���� ���̾�
	// 3. ��û ó�� �޼ҵ��� ��ȯ���� ModelAndView�� �ۼ��ϸ� ModelAndView ��ü�� ViewName�� �����Ͽ� ����
	
	// Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �޼ҵ�
	// @RequestMapping : Ŭ���̾�Ʈ ��û����(URL)�� ����Ͽ� Ŭ���̾�Ʈ ��û�� �޼ҵ带 ȣ���ϴ� ������̼� >> JSP���� ���
	//  => JSON��? @GetMapping, @PostMapping, @PutMapping, @DeleteMapping ���� ������̼����� ��� ����
	// value �Ӽ� : Ŭ���̾�Ʈ�� ��û����(URL)�� �Ӽ������� ���� >> value�� ��û�ϸ� �ش� �޼ҵ� ȣ��
	//  => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	//  => �ٸ� ��û ó�� �޼ҵ�� ��û����(URL)�� �ߺ��� ��� WAS ����� ����
	@RequestMapping(value = "/hello")
	public void hello() {
		// ��û ó�� ��� �ۼ� >> Service Ŭ������ �޼ҵ� ȣ��
		logger.info("/hello ��û >> HelloController Ŭ������ hello() �޼ҵ� ȣ�� ");
	}
	
	@RequestMapping("/helloViewName")
	public String helloViewName() {
		logger.info("/hello ��û >> helloViewName Ŭ������ helloViewName() �޼ҵ� ȣ�� ");
		// return "viewName";
		return "hello";
	}
	
	@RequestMapping("/helloModelAndView")
	public ModelAndView helloModelAndView() {
		logger.info("/hello ��û >> ModelAndView Ŭ������ helloModelAndView() �޼ҵ� ȣ�� ");
		
		/*
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("hello");
		setViewName("viewName");
		*/
		
		// ModelAndView ��ü ������ �����ڷ� ViewName�� ���޹޾� ����
		// new ModelAndView("viewName");
		ModelAndView modelAndView= new ModelAndView("hello");
		return modelAndView;
	}
}
