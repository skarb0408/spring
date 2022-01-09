package xyz.itwill08.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("08_dao.xml");
		System.out.println("=========================================================================");
		StudentService service= context.getBean("studentService", StudentService.class);
		
		/*
		Student student=new Student();
		student.setNo(5000);
		student.setName("�����");
		student.setPhone("010-1111-1111");
		student.setAddress("������ ���뱸");
		student.setBirthday("2002-02-22");
		service.addStudent(student);
		*/
		
		/*
		Student student= service.getStudent(5000);
		student.setName("�ڸ��");
		student.setBirthday("2002-08-08");
		service.modifyStudent(student);
		*/
		
		/*
		service.removeStudent(5000);
		*/
		
		
		List<Student> studentList= service.getStudentList();
		for(Student stu:studentList) {
			System.out.println(stu.getNo()+", "+stu.getName()+", "+stu.getPhone()
					+", "+stu.getAddress()+", "+stu.getBirthday().substring(0,10));
		}
		
		System.out.println("=========================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
