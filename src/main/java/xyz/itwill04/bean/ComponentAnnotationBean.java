package xyz.itwill04.bean;

import org.springframework.stereotype.Component;

// @Component : 클래스를 Spring Bean으로 등록하기 위한 어노테이션
//  => 기본적으로 클래스명을 beanName으로 설정 => 첫문자는 소문자로 자동 변환
// @Component 어노테이션의 value 속성을 사용하여 beanName 변경도 가능하다.
//  => 다른 속성이 없는 경우 속성값만 설정 가능
@Component("bean")
public class ComponentAnnotationBean {
	public ComponentAnnotationBean() {
		System.out.println("### ComponentAnnotationBean 클래스의 기본 생성자 호출 ###");
	}
	
	public void display() {
		System.out.println("*** ComponentAnnotationBean 클래스의 display() 메소드 호출 ***");
	}
}
