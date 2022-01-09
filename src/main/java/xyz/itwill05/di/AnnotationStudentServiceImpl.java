package xyz.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component

// @Service : Service 클래스를 Spring Bean으로 등록하기 위한 어노테이션
//  => 기본적으로 클래스명을 beanName으로 설정하며 value 속성을 사용하여 beanName 변경 가능 
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	// @Autowired : Spring Bean 객체로 필드에 자동으로 의존관계를 설정하는 기능을 제공하는 어노테이션
	//  => 필드에 Setter 메소드를 선언하지 않아도 Setter Injection 기능을 제공
	//  => bean 엘리먼트에 autowire 속성의 [byType] 속성값과 동일한 방법으로 의존관계 설정
	//  => 필드가 인터페이스로 설정되어있으면 상속받고 있는 자식클래스로 자동 인젝션!
	// 문제점) 필드의 자료형이 인터페이스라면 자식클래스로 등록된 Spring Bean이 여러 개인 경우
	// 		 의존관계를 설정할 때 NoUniqueBeanDefinitionException 예외 발생
	// 해결법-1) String bean으로 등록된 자식클래스 중 하나의 beanName을 필드명과 같은 이름으로 변경
	//  => 자식클래스의 Spring Bean이 여러 개 등록된 경우 autowire 속성의 [byName] 속성값과 같은 방법으로 의존관계 설정
	//  => 같은 beanName이 여러개라면 걍 망함 애초에 등록이 안댐
	// 해결법-2) @Qualifier 어노테이션을 사용하여 의존관계를 설정할 Spring Bean 선택(@Autowrired 없으면 못씀)
	// @Qualifier : 의존관계를 설명하고자 하는 Spring Bean을 선택하기 위한 어노테이션
	//  => @Autowired 어노테이션에 종속된 어노테이션
	//  => 의존관계를 설정할 Spring Bean의 beanName을 value 속성값으로 설정 >> 다른 속성이 없으면 속성값만 설정 가능
	@Autowired // 자동 인젝션 시키기
	//@Qualifier("annotationStudentJdbcDAO")
	@Qualifier("annotationStudentMybatisDAO")
	// @Resource : Spring Framework의 @Autowired 어노테이션을 바탕으로 만들어진 어노테이션
	//  => JDK 라이브러리에 의해 제공되는 어노테이션 >> 다른 Framework에서 사용 가능
	//  => 기본적으로 [byName] 형식으로 의존관계 설정
	// @Inject :  Spring Framework의 @Autowired 어노테이션을 바탕으로 만들어진 어노테이션
	//  => JDK 라이브러리에 의해 제공되는 어노테이션 >> 다른 Framework에서 사용 가능
	//  => 기본적으로 [byType] 형식으로 의존관계 설
	private StudentDAO studentDAO; // Injection
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public void addStudent(Student studnet) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 addStudent() 메소드 호출 ***");
		studentDAO.insertStudent(studnet);
		
	}

	@Override
	public void modifyStudent(Student studnet) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 modifyStudent() 메소드 호출 ***");
		studentDAO.updateStudent(studnet);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 removeStudent() 메소드 호출 ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudent() 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentLsit();
	}

}
