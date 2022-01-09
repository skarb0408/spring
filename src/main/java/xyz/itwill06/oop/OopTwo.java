package xyz.itwill06.oop;

public class OopTwo {
	/*
	public void beforeLog() {
		System.out.println("### 메소드의 명령 실행전 기록 ###");
	}
	*/
	
	OopLogger logger= new OopLogger(); // 관계를 맺어줌

	
	public void display1() {
		//System.out.println("### 메소드의 명령 실행전 기록 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo 클래스의 display1() 메소드 호출 ***");
	}
	public void display2() {
		//System.out.println("### 메소드의 명령 실행전 기록 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo 클래스의 display2() 메소드 호출 ***");
	}
	public void display3() {
		//System.out.println("### 메소드의 명령 실행전 기록 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo 클래스의 display3() 메소드 호출 ***");
	}
}
