package xyz.itwill07.aop;

import java.util.List;

//�ٽɰ��ɸ���� ����� Ŭ����
// => �ٽɰ��ɸ��(Core Concern Module) : �ٽɰ����ڵ尡 �ۼ��� �޼ҵ�
// => �ٽɰ����ڵ� : �޼ҵ尡 �����ϴ� ����� �����ϱ� ���� ���(��������) 
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	// �����ǽ� Setter �ʿ�
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent() �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
		
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStuent() �޼ҵ� ȣ�� ***");		
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");		
		return studentDAO.selectStudentList();
	}

}
