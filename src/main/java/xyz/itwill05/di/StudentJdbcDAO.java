package xyz.itwill05.di;

import java.util.List;

// DAO 클래스 : 저장매체(File, DBMS 등)에 행에대한 삽입, 변경, 삭제, 검색 기능을 제공하는 클래스
//  => 저장매체의 종류 또는 방법에 따라 Service 클래스가 사용할 DAO 클래스 변경
//  => DAO 클래스가 변경되어도 Service 클래스의 영향을 최소화 하기 위해 인터페이스를 상속받아 사용
public class StudentJdbcDAO implements StudentDAO {
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO 클래스 기본 생성자 호출 ###");
	}
	
	// 삽입
	@Override
	public  int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAO 클래스의 insertStudent() 메소드 호출");
		return 0;
	}
	
	// 변경
	@Override
	public  int updateStudent(Student student) {
		System.out.println("*** StudentJdbcDAO 클래스의 updateStudent() 메소드 호출");
		return 0;
	}
	
	// 삭제
	@Override
	public  int deleteStudent(int num) {
		System.out.println("*** StudentJdbcDAO 클래스의 deleteStudent() 메소드 호출");
		return 0;
	}
	
	// 하나 찾기
	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAO 클래스의 selectStudent() 메소드 호출");
		return null;
	}
	
	// 모두 찾기
	@Override
	public List<Student> selectStudentLsit() {
		System.out.println("*** StudentJdbcDAO 클래스의 selectStudentLsit() 메소드 호출");
		return null;
	}
}
