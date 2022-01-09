package xyz.itwill08.dao;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	// Bean Configuration File���� StudentServiceImple Ŭ������ Spring Bean���� ����� ��
	// StudentDAOImple Ŭ������ Spring Bean�� �ʵ忡 �������Ͽ� �������� ���� - DI
	//  => �θ� �������̽��� �ʵ��� �ڷ������� �����ϸ� ��� �ڽ�Ŭ������ ��ü ����
	private StudentDAO studentDAO;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	// ������ DAO Ŭ������ �޼ҵ常 ȣ���ϴ� ���� �ƴ� �Է°� ������ ���־���!
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
