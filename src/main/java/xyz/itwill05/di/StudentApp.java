package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		// 객체들을 미리 생성
		ApplicationContext context= new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("======================================================");
		
		// 기본 생성자 호출
		Student student1= context.getBean("student1", Student.class);
		System.out.println(student1);
		System.out.println("======================================================");
		
		// 학번만 들어간 생성자 호출
		Student student2= context.getBean("student2", Student.class);
		System.out.println(student2);
		System.out.println("======================================================");
		
		// 학번, 이름, 이메일이 들어간 생성자 호출 -1
		//  => constructor-arg를 이용한 값 넣기
		Student student3= context.getBean("student3", Student.class);
		System.out.println(student3);
		System.out.println("======================================================");
		
		// 학번, 이름, 이메일이 들어간 생성자 호출 -2
		//  => property를 이용한 값 넣기(Setter)
		Student student4= context.getBean("student4", Student.class);
		System.out.println(student4);
		System.out.println("======================================================");
		
		// 학번, 이름, 이메일이 들어간 생성자 호출 -3
		//  => constructor-arg 과 property를 이용한 값 넣기(Setter)
		Student student5= context.getBean("student5", Student.class);
		System.out.println(student5);
		System.out.println("======================================================");
		
		// 학번, 이름, 이메일이 들어간 생성자 호출 -4
		//  => properties 파일을 이용하여 값 넣기
		Student student6= context.getBean("student6", Student.class);
		System.out.println(student6);
		System.out.println("======================================================");
		
		// String Bean으로 등록된 Service 클래스의 객체를 제공받아 프로그램 실행에 필요한 기능을
		// 메소드로 호출하여 동작되도록 구현
		//  => 객체를 저장하는 참조형은 인터페이스로 만들자
		StudentService studentService= context.getBean("studentServiceImpl", StudentServiceImpl.class);
		
		studentService.addStudent(student1);
		studentService.modifyStudent(student1);
		studentService.removeStudent(1000);
		studentService.getStudent(1000);
		studentService.getStudentList();
		System.out.println("======================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
