package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
// @Aspect : Spring Bean���� ��ϵ� Ŭ������ �޼ҵ忡 Aspect ����� �����ϱ� ���� ������̼�
//  => Bean Configuration File�� aspect ������Ʈ�� ������ ��� ����
@Aspect
public class AopAnnotaionAdvice {
	private static final Logger logger= LoggerFactory.getLogger(AopAnnotaionAdvice.class);
	
	// @Pointcut : �ٽɰ��ɸ���� Ÿ�ϸ޼ҵ�� �����ϱ� ���� ������̼�
	//  => Bean Configuration File�� pointcut ������Ʈ�� ������ ��� ����
	//  => Pointcut�� ���� ������ ���� ����
	//  => �޼ҵ��� �Ű������� Pointcut �ĺ��ڷ� ���Ǹ� �޼ҵ� ȣ���������� Pointcut ���
	@Pointcut("within(xyz.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}
	
	// @Before : Before Advice �޼ҵ带 �����ϴ� ������̼�
	//  => Bean Configuration File�� before ������Ʈ�� ������ ��� ����
	// value �Ӽ� : Ÿ�ٸ޼ҵ带 �����ϱ� ���� ���� (execution �Ǵ� within)�� �Ӽ������� ���� 
	//  => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ǥ�� ����  
	//  => @PointCut ������̼����� ������ �޼ҵ带 ȣ���Ͽ� Ÿ�ϸ޼ҵ� ����
	
	//@Before("within(xyz.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut()")
	public void beforeLog() {
		logger.info("[before] �ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	// @AfterReturning : After Returning Advice �޼ҵ带 �����ϴ� ����޽äŤ�
	//  => Bean Configuration File�� after-returning ������Ʈ�� ������ ��� ����
	// returning �Ӽ� : Ÿ�ϸ޼ҵ��� ��ȯ���� �����ϱ� ���� �Ű��������� �Ӽ������� ����
	@AfterReturning(value = "aopPointCut()", returning = "object")
	public void afterReturningLog(Object object) {
		logger.info("[after-returning] �ٽɰ����ڵ尡 ���������� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	
	// @AfterThrowing : After Throwing Advice �޼ҵ带 �����ϴ� ������̼�
	//  => Bean Configuration File�� after-throwing ������Ʈ�� ������ ��� ����
	// throwing �Ӽ� : Ÿ�ٸ޼ҵ忡�� �߻��� ���ܸ� �����ϱ� ���� �Ű��������� �Ӽ������� ���� 
	@AfterThrowing(value = "aopPointCut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		logger.info("[after-throwing] �ٽɰ����ڵ尡 ����� ���ܰ� �߻��� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	//@After : After Advice �޼ҵ带 �����ϴ� ������̼�
	// => Bean Configuration File�� after ������Ʈ�� ������ ��� ����
	@After("aopPointCut()")
	public void afterLog() {
		logger.info("[after] �ٽɰ����ڵ� ���� �� ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	//@Around : After Advice �޼ҵ带 �����ϴ� ������̼�
	// => Bean Configuration File�� around ������Ʈ�� ������ ��� ����
	@Around("aopPointCut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around] �ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		Object object= joinPoint.proceed();
		logger.info("[around] �ٽɰ����ڵ� ���� �� ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		return object;
		
	}
}