package xyz.itwill03.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Spring Container�� �̿��Ͽ� ��ü�� �����޾� ���
//  => �����ڰ� �ƴ� Spring Container�� ��ü�� ���� => Spring IoC
//  => Spring Bean Configuration File(XML)�� �̿��Ͽ� ��ü ������ ��ü���� �������� �������־���Ѵ�.
public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object= new HelloMessageObject(); -- �ν��Ͻ��� ���� �������
		MessagePrint print= new MessagePrint(); -- �ν��Ͻ��� ���� ������� => ���յ� ����
		print.setObject(object); // ���԰���(��������) ����
		print.messagePrint();
		*/
		
		// ApplicationContext ��ü(Spring Container) ����
		//  => Spring Bean Configuration File�� �����޾� Spring Bean�� �����Ͽ� ����
		// �����̳� �����ؼ� xml ���� �ְ�
		ApplicationContext context= new ClassPathXmlApplicationContext("03_message.xml");
		
		// Spring Container�� �����ϴ� Spring Bean�� �����޾� ����
		//  => bean ������Ʈ�� �ĺ���(beanName)�� �����Ͽ� Spring Container�� ���� Spring Bean ��ȯ
		// beanName�� messagePrint�� �긦 ����
		// bean�� �����޾� �޼ҵ� ȣ��
		MessagePrint print= (MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
		// Spring Container ���� => Spring Container�� �����ϴ� ��� Spring Bean�� ���ŵȴ�. 
		((ClassPathXmlApplicationContext)context).close(); // �� �����൵��
	}
}
