package xyz.itwill07.aop;

import java.util.List;

// 핵심관심모듈이 선언된 클래스
//  => 핵심관심모듈(Core Concern Module) : 핵심관심코드가 작성된 메소드
//  => 핵심관심코드 : 메소드가 제공하는 기능을 구현하기 위한 명령(실질적인)

public class StudentDAOImpl	implements StudentDAO {
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentDAOImpl 클래스의 insertStudent() 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentDAOImpl 클래스의 selectStudent() 메소드 호출 ***");		
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentDAOImpl 클래스의 selectStudentList() 메소드 호출 ***");
		//throw new RuntimeException(); // 일부러 예외발생
		return null;
	}

}
