package xyz.itwill07.aop;

import java.sql.Timestamp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	private static final Logger logger= LoggerFactory.getLogger(ExecutionTimeAdvice.class);	
	Timestamp time= null;
	
	// Ÿ�ٸ޼ҵ��� ����� ����Ǵ� ó���ð�(ms)�� ����Ͽ� ����ϴ� �޼ҵ�
	// timeWatchLog >> ó���ð��� ó���ϴ� ���
	
	/*
	 * public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
	 * long start= new Timestamp(System.currentTimeMillis()).getTime(); //long
	 * start= new Timestamp(System.nanoTime()).getTime(); logger.info("����"); Object
	 * object= joinPoint.proceed(); // ���� �޼ҵ� ���� long end= new
	 * Timestamp(System.currentTimeMillis()).getTime(); //long end= new
	 * Timestamp(System.nanoTime()).getTime(); logger.info("����");
	 * 
	 * float cho= (end-start);
	 * 
	 * System.out.println("�ɸ��ð� = "+ ((end-start)/1000.0)+"��");
	 * //System.out.println("�ɸ��ð� = "+ ((end-start)/1000000000.0)+"��");
	 * System.out.println("�ɸ��ð� = "+(cho)+"ms"); return object; }
	 */
	
	// Ÿ�ٸ޼ҵ��� ����� ����Ǵ� ó���ð�(ms)�� ����Ͽ� ����ϴ� �޼ҵ� - Around 
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		// Ÿ�ٸ޼ҵ� ���� �� ���۵� ��� �ۼ�
		// System.currentTimMills() : �ý����� ���� Ÿ�ӽ�����(TimeStamp)�� ��ȯ�ϴ� �޼ҵ�
		//  => Ÿ�ӽ�����(TimeStamp) : ��¥�� �ð��� ����(long)�� ǥ���ϱ� ���� ��
		/*
		 * long startTime= System.currentTimeMillis();
		 * 
		 * Object object= joinPoint.proceed(); Ÿ�ϸ޼ҵ� ȣ�� - Ÿ�ϸ޼ҵ� ��� ����
		 * 
		 * // Ÿ�ٸ޼ҵ� ���� �� ���۵� ��� �ۼ� long endTime= System.currentTimeMillis();
		 * 
		 * logger.info("");
		 * 
		 * String className= joinPoint.getTarget().getClass().getSimpleName(); String
		 * methodName= joinPoint.getSignature().getName();
		 * logger.info(className+"�� "+methodName+"���� �ɸ� �ð��� "+(endTime-startTime));
		 */
		
		// StopWatch : �ð��� �����ϱ� ���� ����� �����ϴ� Ŭ����
		StopWatch stopWatch= new StopWatch();
		
		// StopWatch.start() : �ð� ������ �����ϴ� �޼ҵ�
		stopWatch.start();
		
		Object object= joinPoint.proceed(); // Ÿ�ϸ޼ҵ� ȣ�� - Ÿ�ϸ޼ҵ� ��� ����
		
		// StopWatch.stop() : �ð� ������ �����ϴ� �ޙ�
		stopWatch.stop();
		
		String className= joinPoint.getTarget().getClass().getSimpleName(); String
		 methodName= joinPoint.getSignature().getName();
		// StopWatch.getTotalTimeMillis() : ������ �ð�(ms)�� ��ȯ�ϴ� �޼ҵ�
		logger.info(className+" Ŭ������ "+ methodName+ " �޼ҵ� ���� �ð� = "
					+ stopWatch.getTotalTimeMillis()+"ms");	
		
		return object;
		
	}
}
