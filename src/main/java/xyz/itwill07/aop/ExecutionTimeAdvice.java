package xyz.itwill07.aop;

import java.sql.Timestamp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	private static final Logger logger= LoggerFactory.getLogger(ExecutionTimeAdvice.class);	
	Timestamp time= null;
	
	// 타겟메소드의 명령이 실행되는 처리시간(ms)를 계산하여 기록하는 메소드
	// timeWatchLog >> 처리시간을 처리하는 명령
	
	/*
	 * public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
	 * long start= new Timestamp(System.currentTimeMillis()).getTime(); //long
	 * start= new Timestamp(System.nanoTime()).getTime(); logger.info("시작"); Object
	 * object= joinPoint.proceed(); // 원래 메소드 실행 long end= new
	 * Timestamp(System.currentTimeMillis()).getTime(); //long end= new
	 * Timestamp(System.nanoTime()).getTime(); logger.info("종료");
	 * 
	 * float cho= (end-start);
	 * 
	 * System.out.println("걸린시간 = "+ ((end-start)/1000.0)+"초");
	 * //System.out.println("걸린시간 = "+ ((end-start)/1000000000.0)+"초");
	 * System.out.println("걸린시간 = "+(cho)+"ms"); return object; }
	 */
	
	// 타겟메소드의 명령이 실행되는 처리시간(ms)를 계산하여 기록하는 메소드 - Around 
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		// 타겟메소드 실행 전 동작될 명령 작성
		// System.currentTimMills() : 시스템의 현재 타임스탬프(TimeStamp)를 반환하는 메소드
		//  => 타임스탬프(TimeStamp) : 날짜와 시간을 정수(long)로 표현하기 위한 값
		/*
		 * long startTime= System.currentTimeMillis();
		 * 
		 * Object object= joinPoint.proceed(); 타켓메소드 호출 - 타켓메소드 명령 실행
		 * 
		 * // 타겟메소드 실행 후 동작될 명령 작성 long endTime= System.currentTimeMillis();
		 * 
		 * logger.info("");
		 * 
		 * String className= joinPoint.getTarget().getClass().getSimpleName(); String
		 * methodName= joinPoint.getSignature().getName();
		 * logger.info(className+"의 "+methodName+"에서 걸린 시간은 "+(endTime-startTime));
		 */
		
		// StopWatch : 시간을 측정하기 위한 기능을 제공하는 클래스
		StopWatch stopWatch= new StopWatch();
		
		// StopWatch.start() : 시간 측정을 시작하는 메소드
		stopWatch.start();
		
		Object object= joinPoint.proceed(); // 타켓메소드 호출 - 타켓메소드 명령 실행
		
		// StopWatch.stop() : 시간 측정을 종료하는 메솓
		stopWatch.stop();
		
		String className= joinPoint.getTarget().getClass().getSimpleName(); String
		 methodName= joinPoint.getSignature().getName();
		// StopWatch.getTotalTimeMillis() : 측정된 시간(ms)을 반환하는 메소드
		logger.info(className+" 클래스의 "+ methodName+ " 메소드 실행 시간 = "
					+ stopWatch.getTotalTimeMillis()+"ms");	
		
		return object;
		
	}
}
