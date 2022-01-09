package xyz.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AnnotationStudentMybatisDAO implements StudentDAO {
	public AnnotationStudentMybatisDAO() {
		System.out.println("### AnnotationStudentMybatisDAO 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentMybatisDAO 클래스의 insertStudent() 메소드 호출 ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** AnnotationStudentMybatisDAO 클래스의 updateStudent() 메소드 호출 ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** AnnotationStudentMybatisDAO 클래스의 deleteStudent() 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentMybatisDAO 클래스의 selectStudent() 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectStudentLsit() {
		System.out.println("*** AnnotationStudentMybatisDAO 클래스의 selectStudentLsit() 메소드 호출 ***");
		return null;
	}
	
}
