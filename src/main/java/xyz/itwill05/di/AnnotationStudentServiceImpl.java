package xyz.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component

// @Service : Service Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
//  => �⺻������ Ŭ�������� beanName���� �����ϸ� value �Ӽ��� ����Ͽ� beanName ���� ���� 
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	// @Autowired : Spring Bean ��ü�� �ʵ忡 �ڵ����� �������踦 �����ϴ� ����� �����ϴ� ������̼�
	//  => �ʵ忡 Setter �޼ҵ带 �������� �ʾƵ� Setter Injection ����� ����
	//  => bean ������Ʈ�� autowire �Ӽ��� [byType] �Ӽ����� ������ ������� �������� ����
	//  => �ʵ尡 �������̽��� �����Ǿ������� ��ӹް� �ִ� �ڽ�Ŭ������ �ڵ� ������!
	// ������) �ʵ��� �ڷ����� �������̽���� �ڽ�Ŭ������ ��ϵ� Spring Bean�� ���� ���� ���
	// 		 �������踦 ������ �� NoUniqueBeanDefinitionException ���� �߻�
	// �ذ��-1) String bean���� ��ϵ� �ڽ�Ŭ���� �� �ϳ��� beanName�� �ʵ��� ���� �̸����� ����
	//  => �ڽ�Ŭ������ Spring Bean�� ���� �� ��ϵ� ��� autowire �Ӽ��� [byName] �Ӽ����� ���� ������� �������� ����
	//  => ���� beanName�� ��������� �� ���� ���ʿ� ����� �ȴ�
	// �ذ��-2) @Qualifier ������̼��� ����Ͽ� �������踦 ������ Spring Bean ����(@Autowrired ������ ����)
	// @Qualifier : �������踦 �����ϰ��� �ϴ� Spring Bean�� �����ϱ� ���� ������̼�
	//  => @Autowired ������̼ǿ� ���ӵ� ������̼�
	//  => �������踦 ������ Spring Bean�� beanName�� value �Ӽ������� ���� >> �ٸ� �Ӽ��� ������ �Ӽ����� ���� ����
	@Autowired // �ڵ� ������ ��Ű��
	//@Qualifier("annotationStudentJdbcDAO")
	@Qualifier("annotationStudentMybatisDAO")
	// @Resource : Spring Framework�� @Autowired ������̼��� �������� ������� ������̼�
	//  => JDK ���̺귯���� ���� �����Ǵ� ������̼� >> �ٸ� Framework���� ��� ����
	//  => �⺻������ [byName] �������� �������� ����
	// @Inject :  Spring Framework�� @Autowired ������̼��� �������� ������� ������̼�
	//  => JDK ���̺귯���� ���� �����Ǵ� ������̼� >> �ٸ� Framework���� ��� ����
	//  => �⺻������ [byType] �������� �������� ��
	private StudentDAO studentDAO; // Injection
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public void addStudent(Student studnet) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ addStudent() �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(studnet);
		
	}

	@Override
	public void modifyStudent(Student studnet) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ modifyStudent() �޼ҵ� ȣ�� ***");
		studentDAO.updateStudent(studnet);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ removeStudent() �޼ҵ� ȣ�� ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudent() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentLsit();
	}

}
