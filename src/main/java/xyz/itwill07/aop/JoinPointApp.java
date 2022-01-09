package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JoinPointApp {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("07-2_param.xml");
		System.out.println("============================================================================");
		JoinPoingBean bean= context.getBean("joinPoingBean", JoinPoingBean.class);
		
		bean.add();
		System.out.println("============================================================================");
		
		bean.modify(1000, "ȫ�浿");
		System.out.println("============================================================================");
		
		bean.remove(2000);
		System.out.println("============================================================================");
		
		bean.getName();
		System.out.println("============================================================================");
		
		bean.calc(20, 0);
		System.out.println("============================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
