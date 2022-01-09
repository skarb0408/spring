package xyz.itwill05.di;

import java.util.List;

//학생정보를 처리하는 DAO 클래스가 반드시 상속받아야 되는 인터페이스
//  => ??
public interface StudentDAO {

	// 삽입
	int insertStudent(Student student);

	// 변경
	int updateStudent(Student student);

	// 삭제
	int deleteStudent(int num);

	// 하나 찾기
	Student selectStudent(int num);

	// 모두 찾기
	List<Student> selectStudentLsit();

}