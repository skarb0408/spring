package xyz.itwill05.di;

import java.util.List;

public class StudentMybatisDAO implements StudentDAO {
		public StudentMybatisDAO() {
			System.out.println("### StudentMybatisDAO Ŭ���� �⺻ ������ ȣ�� ###");
		}
	
		// ����
		@Override
		public  int insertStudent(Student student) {
			System.out.println("*** StudentMybatisDAO Ŭ������ insertStudent() �޼ҵ� ȣ��");
			return 0;
		}
		
		// ����
		@Override
		public  int updateStudent(Student student) {
			System.out.println("*** StudentMybatisDAO Ŭ������ updateStudent() �޼ҵ� ȣ��");
			return 0;
		}
		
		// ����
		@Override
		public  int deleteStudent(int num) {
			System.out.println("*** StudentMybatisDAO Ŭ������ deleteStudent() �޼ҵ� ȣ��");
			return 0;
		}
		
		// �ϳ� ã��
		@Override
		public Student selectStudent(int num) {
			System.out.println("*** StudentMybatisDAO Ŭ������ selectStudent() �޼ҵ� ȣ��");
			return null;
		}
		
		// ��� ã��
		@Override
		public List<Student> selectStudentLsit() {
			System.out.println("*** StudentMybatisDAO Ŭ������ selectStudentLsit() �޼ҵ� ȣ��");
			return null;
		}
}
