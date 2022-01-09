package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanApp {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("05-2_collection.xml");
		System.out.println("===============================================================");
		CollectionBean bean= context.getBean("collectionBean", CollectionBean.class);
		
		System.out.println("nameList = "+bean.getNameList());
		System.out.println("setList = "+bean.getNameSet());
		System.out.println("ControllerList = "+bean.getControllerList());
		System.out.println("ControllerSet = "+bean.getControllerSet());
		System.out.println("ControllerMap = "+bean.getControllerMap());
		System.out.println("ControllerProperties = "+bean.getControllerProperties());
		System.out.println("===============================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
