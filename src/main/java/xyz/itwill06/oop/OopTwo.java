package xyz.itwill06.oop;

public class OopTwo {
	/*
	public void beforeLog() {
		System.out.println("### �޼ҵ��� ��� ������ ��� ###");
	}
	*/
	
	OopLogger logger= new OopLogger(); // ���踦 �ξ���

	
	public void display1() {
		//System.out.println("### �޼ҵ��� ��� ������ ��� ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo Ŭ������ display1() �޼ҵ� ȣ�� ***");
	}
	public void display2() {
		//System.out.println("### �޼ҵ��� ��� ������ ��� ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo Ŭ������ display2() �޼ҵ� ȣ�� ***");
	}
	public void display3() {
		//System.out.println("### �޼ҵ��� ��� ������ ��� ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo Ŭ������ display3() �޼ҵ� ȣ�� ***");
	}
}
