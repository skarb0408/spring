package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		// ��ü���� �̸� ����
		ApplicationContext context= new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("======================================================");
		
		// �⺻ ������ ȣ��
		Student student1= context.getBean("student1", Student.class);
		System.out.println(student1);
		System.out.println("======================================================");
		
		// �й��� �� ������ ȣ��
		Student student2= context.getBean("student2", Student.class);
		System.out.println(student2);
		System.out.println("======================================================");
		
		// �й�, �̸�, �̸����� �� ������ ȣ�� -1
		//  => constructor-arg�� �̿��� �� �ֱ�
		Student student3= context.getBean("student3", Student.class);
		System.out.println(student3);
		System.out.println("======================================================");
		
		// �й�, �̸�, �̸����� �� ������ ȣ�� -2
		//  => property�� �̿��� �� �ֱ�(Setter)
		Student student4= context.getBean("student4", Student.class);
		System.out.println(student4);
		System.out.println("======================================================");
		
		// �й�, �̸�, �̸����� �� ������ ȣ�� -3
		//  => constructor-arg �� property�� �̿��� �� �ֱ�(Setter)
		Student student5= context.getBean("student5", Student.class);
		System.out.println(student5);
		System.out.println("======================================================");
		
		// �й�, �̸�, �̸����� �� ������ ȣ�� -4
		//  => properties ������ �̿��Ͽ� �� �ֱ�
		Student student6= context.getBean("student6", Student.class);
		System.out.println(student6);
		System.out.println("======================================================");
		
		// String Bean���� ��ϵ� Service Ŭ������ ��ü�� �����޾� ���α׷� ���࿡ �ʿ��� �����
		// �޼ҵ�� ȣ���Ͽ� ���۵ǵ��� ����
		//  => ��ü�� �����ϴ� �������� �������̽��� ������
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
