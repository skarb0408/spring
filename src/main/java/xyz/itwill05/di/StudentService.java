package xyz.itwill05.di;

import java.util.List;

// �л������� ó���ϴ� Service Ŭ������ �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
//  =>  ??
public interface StudentService {
	void addStudent(Student studnet);
	void modifyStudent(Student studnet);
	void removeStudent(int num);
	Student getStudent(int num);
	List<Student> getStudentList();
}
