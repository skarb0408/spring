package xyz.itwill07.aop;

import java.util.List;

//핵심관심모듈이 선언된 클래스
// => 핵심관심모듈(Core Concern Module) : 핵심관심코드가 작성된 메소드
// => 핵심관심코드 : 메소드가 제공하는 기능을 구현하기 위한 명령(실질적인) 
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	// 인젝션시 Setter 필요
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent() 메소드 호출 ***");
		studentDAO.insertStudent(student);
		
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStuent() 메소드 호출 ***");		
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");		
		return studentDAO.selectStudentList();
	}

}
