package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//���� ���� ���� �޼��� ����� �����ϴ� Ŭ���� - Advice
public class EmailSendAdvice {
	//���� ���� �� ����� ����� �ۼ��� �޼ҵ� - Before Advice
	// => JoinPoint �Ű������� Ÿ�ٸ޼ҵ�(EmailSendBean Ŭ������ sendEmail �޼ҵ�)�� 
	//�Ű��������� �̿��Ͽ� �޼��� ��� ��� ����
	public void beforeMessage(JoinPoint joinPoint) {
		String email=(String)joinPoint.getArgs()[0];
		String subject=(String)joinPoint.getArgs()[1];
		System.out.println("[�޼���]<"+email+">�Կ��� <"+subject+"> ������ �̸����� �����մϴ�.");
	}
	
	//���� ������ ������ �� ����� ����� �ۼ��� �޼ҵ� - After Returning Advice
	// => �Ű������� ����� Ÿ�ٸ޼ҵ�(EmailSendBean Ŭ������ sendEmail �޼ҵ�)�� ��ȯ����
	//�̿��Ͽ� �޼��� ��� ��� ����
	public void successMessage(String email) {
		System.out.println("[�޼���]<"+email+">�Կ��� �̸����� ���������� ���� �Ͽ����ϴ�.");
	}
	
	//���� ������ ������ �� ����� ����� �ۼ��� �޼ҵ� - After Throwing Advice
	// => �Ű������� ����� Ÿ�ٸ޼ҵ�(EmailSendBean Ŭ������ sendEmail �޼ҵ�)�� ���ܸ�
	//�̿��Ͽ� �޼��� ��� ��� ����
	public void failMessage(Exception exception) {
		System.out.println("[����]�̸��� ���� ���� = "+exception.getMessage());
	}
	
}





