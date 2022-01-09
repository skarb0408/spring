package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

// Ⱦ�ܱ��ɸ���� ����� Ŭ����
public class JoinPointAdvice {
	// Around Advice �޼ҵ带 ������ ������ Advice �޼ҵ�� ��ȯ���� void�� �ۼ��ϰ� �Ű������� 
	// ���ۼ����� �ϰų� JoinPoint �ڷ������� �ϴ� �Ű������� �ۼ��� �� �ִ�.
	// JoinPoint : Ÿ�ϸ޼ҵ�(�ٽɰ��ɸ��)�� ������ �����ϱ� ���� ��ü
	//  => Spring Container�� Advice �޼ҵ带 ȣ���� �� Ÿ�ٸ޼ҵ��� ������ �ڵ����� JoinPoint �Ű������� ����
	//  => Advice �޼ҵ�(Ⱦ�ܰ����ڵ�)���� Ÿ�ٸ޼ҵ��� ������ �ʿ��� ��� JoinPoint �Ű����� �ۼ�
	public void displayTarget(JoinPoint joinPoint) { // before Advice
		//System.out.println("[before] �ٽɰ��ɸ�� ���� �� ���ԵǾ� ����� Ⱦ�� ���ɸ��");
		
		// joinPoint.getTarget() : Ÿ�ٸ޼ҵ带 ȣ���ϴ� ��ü(Spring Bean)�� ��ȯ�ϴ� �޼ҵ�
		//  => Ÿ�ٸ޼ҵ尡 ����� Ŭ���� ��ü�� Object Ÿ������ ��ȯ
		// Object.getClass() : ��ü�� ���� Ŭ���� ����(Class ��ü - Clazz)�� ��ȯ�ϴ� �޼ҵ�
		// Class.getName() : Ŭ���� ��ü(Clazz)�� Ŭ������(��Ű�� ����)�� ��ȯ�ϴ� �޼ҵ�
		//System.out.println(joinPoint.getTarget().getClass().getName());
		// Class.getSimpleName() : Class ��ü(Clazz)�� Ŭ������(��Ű�� ������)�� ��ȯ�ϴ� �޼ҵ�
		//System.out.println(joinPoint.getTarget().getClass().getSimpleName());
		
		// joinPoint.getSignature() : Ÿ�ٸ޼ҵ��� ����(Signature ��ü)�� ��ȯ�ϴ� �޼ҵ�
		// Signature.getName() : Signature ��ü�� Ÿ�ٸ޼ҵ���� ��ȯ�ϴ� �޼ҵ�
		//System.out.println(joinPoint.getSignature().getName());
		String className= joinPoint.getTarget().getClass().getSimpleName();
		String methodName= joinPoint.getSignature().getName();
		//System.out.println("[before] "+className+" Ŭ������ "+ methodName+"() �޼ҵ� ȣ��");
		
		// JoinPoint.getArgs() : Ÿ�ٸ޼ҵ��� ��� �Ű������� ����� ���� Object �迭�� ��ȯ�ϴ� �޼ҵ�
		Object[] objects= joinPoint.getArgs(); // >> 3���� �� ���� ��
		
		/*
		if(methodName.equals("remove")) {
			int num= (Integer)objects[0];
			System.out.println("[���] " + methodName+"(int num) �޼ҵ��� �Ű������� ���޵� �� = "+num);
		}
		*/
		System.out.println("[before] "+className+" Ŭ������ "+ methodName
				+"() �޼ҵ��� ����� �Ű������� ���� = "+ objects.length);	
	}
	
	// After Returning Advice �޼ҵ忡�� JoinPoint �Ű����� Object Ÿ���� �Ű����� �ۼ� ����
	//  => Object Ÿ���� �Ű��������� Ÿ�ٸ޼ҵ��� ��ȯ���� ���޹޾� ����
	//  => Ÿ�ٸ޼ҵ��� ��ȯ���� �ڷ����� ������ ��� Object Ÿ�� ��� ��ȯ���� �ڷ���(Ŭ����) �ۼ� ����
	// after-returning ������Ʈ�� returning �Ӽ��� �Ű��������� �Ӽ������� �ݵ�� �����ؾ߸� Ÿ�ٸ޼ҵ��� ��ȯ���� �Ű������� ���޵Ǿ� ����ȴ�.
	// Ÿ�ٸ޼ҵ��� ��ȯ���� �Ű������� ���޵Ǿ� ����ǵ��� after-returning ������Ʈ���� returning �Ӽ��� �Ű��������� �Ӽ������� �ݵ�� �����ؾ��Ѵ�.(�߿�)
	//  => Ÿ�ϸ޼ҵ尡 �����Ǿ��ִٸ� �� �ڷ����� �����ص��ȴ�.
	public void displayName(Object object) { // After Returning Advice
		//System.out.println("[after-returning] �ٽ� ~~");

		if(object instanceof String) {
			String name= (String)object;
			System.out.println("[after-returning] "+ name + "��, ��������");
		}
	}
	
	// After Throwing Advice �޼ҵ忡�� JoinPoint �Ű����� Exception Ÿ���� �Ű����� �ۼ� ����
	//  => Exception �Ű��������� Ÿ�ٸ޼ҵ忡�� �߻��� ����(Exception ��ü)�� ���޹޾� ����
	// after-throwing ������Ʈ���� throwing �Ӽ��� �Ű��������� �Ӽ������� �ݵ�� �����ؾ߸�
	// Ÿ�ٸ޼ҵ��� ����(Exception ��ü)�� �Ű������� ���޵Ǿ� ����
	public void displayException(Exception exception) { // After Throwing Advice
		//System.out.println("[after throwing] �ٽɰ��ɸ�� ���۽� ���ԵǾ� �����");
		System.out.println("[after-throwing] Ÿ�ٸ޼ҵ忡�� �߻��� ���� �޼��� = "+exception.getMessage());
	}
	
	// Around Advice �޼ҵ�� ��ȯ���� Object Ÿ������ �ۼ��ϰ� �Ű������� ProceedingJoinPoint �ۼ�
	//  => Around Advice �޼ҵ�� Ÿ�ٸ޼ҵ��� ��ȯ���� ��ȯ�ϱ� ���� ��ȯ���� Object�� �ۼ�
	// ProceedingJoinPoint : Ÿ�ٸ޼ҵ��� ������ �����ϱ� ���� ��ü
	//  => Ÿ�ٸ޼ҵ带 ȣ���� �� �ִ� ����� ���� >> Throwable ��ü �߻�
	//  => try catch ���� �� �ʿ䰡 ���⶧����
	//  => Throwable ��ü(���α׷����� �߻��Ǵ� ��� ���� ������ ������ ��ü) ���� >> ���� ����
	public Object display(ProceedingJoinPoint joinPoint) throws Throwable { // Around Advice
		System.out.println("[around] �ٽɰ��ɸ�� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ��ɸ��");
		
		// ProceedingJoinPoint.proceed() : Ÿ�ٸ޼ҵ带 ȣ���ϴ� �޼ҵ� >> �ٽɰ��ɸ�� ����
		//  => Ÿ�ٸ޼ҵ��� ��ȯ���� ��ȯ�޾� ����
		//  => Throwable ��ü(���� ����) �߻� >> ���� ó��
		Object object= joinPoint.proceed();
		
		System.out.println("[around] �ٽɰ��ɸ�� ���� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ��ɸ��");
		
		return object; // Ÿ�ٸ޼ҵ��� ��ȯ�� ��ȯ
	}
}
