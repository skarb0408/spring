package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailSendApp {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("07-4_email.xml");
		System.out.println("============================================================================");
		EmailSendBean bean= context.getBean("emailSendBean", EmailSendBean.class);
		
		
		bean.sendEmail("skarb0408@naver.com", "JavaMail ����� �̿��� �׽�Ʈ", "������");

		System.out.println("============================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
