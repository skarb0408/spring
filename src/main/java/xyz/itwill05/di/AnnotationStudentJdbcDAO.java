package xyz.itwill05.di;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// @Component : Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
//  => �⺻������ Ŭ�������� beanName���� �����ϸ� value �Ӽ��� ����Ͽ� beanName ���� ����
//@Component
//@Component(value = "studentDAO")

// @Repository : DAO Ŭ������ Spring Bean���� ����ϱ� ���� ������̼� >> Ʈ������ ó�� ����
//@Repository("studentDAO")
@Repository
public class AnnotationStudentJdbcDAO implements StudentDAO {
	public AnnotationStudentJdbcDAO() {
		System.out.println("### AnnotationStudentJdbcDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ insertStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ updateStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ deleteStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ selectStudent() �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentLsit() {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ selectStudentLsit() �޼ҵ� ȣ�� ***");
		return null;
	}

}
