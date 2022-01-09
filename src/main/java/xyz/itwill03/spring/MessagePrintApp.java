package xyz.itwill03.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Spring Container를 이용하여 객체를 생성받아 사용
//  => 개발자가 아닌 Spring Container가 객체를 관리 => Spring IoC
//  => Spring Bean Configuration File(XML)을 이용하여 객체 생성과 객체간의 의존관계 설정해주어야한다.
public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object= new HelloMessageObject(); -- 인스턴스를 직접 만들어줌
		MessagePrint print= new MessagePrint(); -- 인스턴스를 직접 만들어줌 => 결합도 높음
		print.setObject(object); // 포함관계(의존관계) 설정
		print.messagePrint();
		*/
		
		// ApplicationContext 객체(Spring Container) 생성
		//  => Spring Bean Configuration File을 제공받아 Spring Bean을 생성하여 관리
		// 컨테이너 생성해서 xml 파일 넣고
		ApplicationContext context= new ClassPathXmlApplicationContext("03_message.xml");
		
		// Spring Container가 관리하는 Spring Bean을 제공받아 저장
		//  => bean 엘리먼트의 식별자(beanName)를 전달하여 Spring Container로 부터 Spring Bean 반환
		// beanName이 messagePrint인 얘를 저장
		// bean을 제공받아 메소드 호출
		MessagePrint print= (MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
		// Spring Container 제거 => Spring Container가 관리하는 모든 Spring Bean도 제거된다. 
		((ClassPathXmlApplicationContext)context).close(); // 꼭 안해줘도댐
	}
}
