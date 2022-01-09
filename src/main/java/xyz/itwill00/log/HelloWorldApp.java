package xyz.itwill00.log;

public class HelloWorldApp {
	public static void main(String[] args) {
		// 로그를 입력하는 프로그램(로그 구현체)이 없을 시 
		//  => 이런 식으로 직접 다 기록해주어야한다.
		//  => 기록을 하기 위한 명령인지 실제 출력하는 명령인지 구분이 어렵다.
		System.out.println("HelloWorldApp main 메소드 시작");
		HelloWorld hw= new HelloWorld();
		String message= hw.hello("홍길동");
		System.out.println("message= "+message);
		System.out.println("HelloWorldApp main 메소드 종료");
	}
}
