package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// log4j 사용해보기
// Logger => org.slf4j.Logger
// LoggerFactory =  ""
public class LogHelloWorldApp {
	// Logger : 로그 구현체에게 기록을 전달하기 위한 인스턴스
	// LoggerFactory : Logger 인스턴스를 제공하기 위한 클래스
	// LoggerFactory.getLogger(class<T> clazz) : 메모리에 저장된 클래스(Clazz)에서 발생된
	// 		기록을 로그 구현체에게 전달하는 Logger 인스턴스를 반환하는 메소드
	private static final Logger logger= LoggerFactory.getLogger(LogHelloWorldApp.class);
	// 무조건 선언한다고 기록되는 것이 아니다.
	// 이러한 클래스에서 이벤트를 발생시킬테니까 기록 좀 해죠
	public static void main(String[] args) {
		// Logger.info(String message) : 로그 이벤트를 발생하여 로그 구현체에게 메세지를 전달하는 메소드 => info레벨의 이벤트
		logger.info("시작");
		LogHelloWorld hw= new LogHelloWorld();
		String message= hw.hello("홍길동");
		System.out.println("message = "+message);
		logger.info("끝");
	}
}
