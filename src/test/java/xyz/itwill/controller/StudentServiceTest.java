package xyz.itwill.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

// �Ϲ������� �׽�Ʈ ���α׷��� DAO, Service Ŭ������ �޼ҵ带 �˻��ϱ� ���� ����
@RunWith(SpringJUnit4ClassRunner.class)
// @WebAppConfiguration : WebApplicationContext ��ü(Spring Container)�� ����Ͽ� 
// Spring Bean�� �����ϵ��� �����ϴ� ������̼� >> ����� ����
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
			"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class StudentServiceTest {
	private static final Logger logger= LoggerFactory.getLogger(DataSourceTest.class);
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testStudentList() {
		List<Student> studentList= studentService.getStudentList();
		
		for(Student student:studentList) {
			//logger.info(student.getNo()+ ", "+student.getName()+", "+student.getPhone()+", "+
						//student.getAddress()+", "+student.getBirthday());
			logger.info(student.toString());
		}
	}
	
	@Test
	public void testStudentAdd() {
		Student student= new Student();
		
		student.setNo(9999);
		student.setName("���籸");
		student.setPhone("010-5487-4545");
		student.setAddress("������ �����");
		student.setBirthday("1997-05-21");
		
		studentService.addStudent(student);
		
	}
}
