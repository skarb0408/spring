package xyz.itwill05.di;

import java.util.List;

public class StudentMybatisDAO implements StudentDAO {
		public StudentMybatisDAO() {
			System.out.println("### StudentMybatisDAO 클래스 기본 생성자 호출 ###");
		}
	
		// 삽입
		@Override
		public  int insertStudent(Student student) {
			System.out.println("*** StudentMybatisDAO 클래스의 insertStudent() 메소드 호출");
			return 0;
		}
		
		// 변경
		@Override
		public  int updateStudent(Student student) {
			System.out.println("*** StudentMybatisDAO 클래스의 updateStudent() 메소드 호출");
			return 0;
		}
		
		// 삭제
		@Override
		public  int deleteStudent(int num) {
			System.out.println("*** StudentMybatisDAO 클래스의 deleteStudent() 메소드 호출");
			return 0;
		}
		
		// 하나 찾기
		@Override
		public Student selectStudent(int num) {
			System.out.println("*** StudentMybatisDAO 클래스의 selectStudent() 메소드 호출");
			return null;
		}
		
		// 모두 찾기
		@Override
		public List<Student> selectStudentLsit() {
			System.out.println("*** StudentMybatisDAO 클래스의 selectStudentLsit() 메소드 호출");
			return null;
		}
}
