package xyz.itwill05.di;

import java.util.List;

// DAO Ŭ���� : �����ü(File, DBMS ��)�� �࿡���� ����, ����, ����, �˻� ����� �����ϴ� Ŭ����
//  => �����ü�� ���� �Ǵ� ����� ���� Service Ŭ������ ����� DAO Ŭ���� ����
//  => DAO Ŭ������ ����Ǿ Service Ŭ������ ������ �ּ�ȭ �ϱ� ���� �������̽��� ��ӹ޾� ���
public class StudentJdbcDAO implements StudentDAO {
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO Ŭ���� �⺻ ������ ȣ�� ###");
	}
	
	// ����
	@Override
	public  int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAO Ŭ������ insertStudent() �޼ҵ� ȣ��");
		return 0;
	}
	
	// ����
	@Override
	public  int updateStudent(Student student) {
		System.out.println("*** StudentJdbcDAO Ŭ������ updateStudent() �޼ҵ� ȣ��");
		return 0;
	}
	
	// ����
	@Override
	public  int deleteStudent(int num) {
		System.out.println("*** StudentJdbcDAO Ŭ������ deleteStudent() �޼ҵ� ȣ��");
		return 0;
	}
	
	// �ϳ� ã��
	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectStudent() �޼ҵ� ȣ��");
		return null;
	}
	
	// ��� ã��
	@Override
	public List<Student> selectStudentLsit() {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectStudentLsit() �޼ҵ� ȣ��");
		return null;
	}
}
