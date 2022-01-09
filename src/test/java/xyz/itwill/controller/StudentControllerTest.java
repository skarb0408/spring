package xyz.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// ��û�� �ؾ���??
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
// ���ϵ� ����(*)�� ����Ͽ� Bean Configuration File ���� ����
//  => ** ���·� ������ ǥ���ϸ� 0�� �̻����� ó��
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class StudentControllerTest {
	private static final Logger logger= LoggerFactory.getLogger(StudentControllerTest.class);
	
	// WebApplicationContext : SpringMVC(�����α׷�)���� ����ϴ� Spring Container ��ü
	@Autowired // => ������ ó��
	private WebApplicationContext context;
	
	// MockMvc : ��û�� ������ �������� �����ϱ� ���� Ŭ���� >> ���� ��ü�� ��������� �׽�Ʈ�� �ʿ��� ��ɸ� ���� ��¥ ��ü
	private MockMvc mvc;
	
	// @Before : �׽�Ʈ �޼ҵ� ȣ�� �� ����� ����� �ۼ��ϴ� �޼ҵ忡 �����ϴ� ������̼� >> �ʱ�ȭ �۾�
	@Before // junit
	public void setup() {
		// MockMvcBuilders.webAppContextSetup(WebApplicationContext context) : MockMvcBuilders ��ü�� ��ȯ�ϴ� �޼ҵ�
		// MockMvcBuilders.build() : MockMvc ��ü�� ��ȯ�ϴ� �޼ҵ�
		mvc= MockMvcBuilders.webAppContextSetup(context).build(); // ������? ��ü����??
		logger.info("MockMvc ��ü ����");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
		// MockMvc.perform(Builder requestBuilder) : �������� Front Controller���� ���ϴ� ����� ��û�ϴ� �����α׷��� ��û�ϴ� �޼ҵ� >> ResultAction ��ü ��ȯ
		// MockMvcRequestBuilders.get(String url) : URL �ּҸ� �����Ͽ� GET ������� ��û�ϴ� �޼ҵ� >> Request
		// ResultAction.andReturn() : ��û ó�� �޼ҵ��� ȣ�� ���(MvcResult ��ü)�� ��ȯ�ϴ� �޼ҵ�
		MvcResult result= mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		logger.info(result.getModelAndView().getViewName());
		logger.info(result.getModelAndView().getModel().toString());
	}
}
