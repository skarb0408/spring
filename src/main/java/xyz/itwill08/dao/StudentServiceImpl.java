package xyz.itwill08.dao;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	// Bean Configuration File에서 StudentServiceImple 클래스를 Spring Bean으로 등록할 때
	// StudentDAOImple 클래스의 Spring Bean을 필드에 인젠션하여 의존관계 설정 - DI
	//  => 부모 인터페이스를 필드의 자료형으로 선언하면 모든 자식클래스의 객체 저장
	private StudentDAO studentDAO;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	// 원래는 DAO 클래스의 메소드만 호출하는 것이 아닌 입력값 검증을 해주어함!
	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int no) {
		studentDAO.deleteStudent(no);
	}

	@Override
	public Student getStudent(int no) {
		return studentDAO.selectStudent(no);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
