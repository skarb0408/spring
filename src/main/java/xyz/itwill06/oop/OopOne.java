package xyz.itwill06.oop;

public class OopOne {
	// 메소드에 중복코드가 존재할 경우 중복코드 대신 사용될 메소드 선언
	//  => 중복코드를 최소화 하여 유지보수의 효율성 증가
	/*
	public void beforeLog() {
		System.out.println("### 메소드의 명령 실행전 기록 ###");
	}
	*/
	
	OopLogger logger= new OopLogger(); // 관계를 맺어줌
	
	// 추상화 캡슐화 위반??
	// 내가 가지고 있어야할 기능을 다른 클래스로 따로 뺌
	//  => 원래는 내가 가지고 있어야되는건 다 내가 가지고 있어야댐
	
	public void display1() {
		//System.out.println("### 메소드의 명령 실행전 기록 ###"); 횡단 관심
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display1() 메소드 호출 ***"); // 핵심 관심
	}
	public void display2() {
		//System.out.println("### 메소드의 명령 실행전 기록 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display2() 메소드 호출 ***");
	}
	public void display3() {
		//System.out.println("### 메소드의 명령 실행전 기록 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display3() 메소드 호출 ***");
	}
}
