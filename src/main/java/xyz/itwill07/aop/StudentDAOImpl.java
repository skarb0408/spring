package xyz.itwill07.aop;

import java.util.List;

// �ٽɰ��ɸ���� ����� Ŭ����
//  => �ٽɰ��ɸ��(Core Concern Module) : �ٽɰ����ڵ尡 �ۼ��� �޼ҵ�
//  => �ٽɰ����ڵ� : �޼ҵ尡 �����ϴ� ����� �����ϱ� ���� ���(��������)

public class StudentDAOImpl	implements StudentDAO {
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentDAOImpl Ŭ������ insertStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentDAOImpl Ŭ������ selectStudent() �޼ҵ� ȣ�� ***");		
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentDAOImpl Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		//throw new RuntimeException(); // �Ϻη� ���ܹ߻�
		return null;
	}

}
