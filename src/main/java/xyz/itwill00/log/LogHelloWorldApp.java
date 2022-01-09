package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// log4j ����غ���
// Logger => org.slf4j.Logger
// LoggerFactory =  ""
public class LogHelloWorldApp {
	// Logger : �α� ����ü���� ����� �����ϱ� ���� �ν��Ͻ�
	// LoggerFactory : Logger �ν��Ͻ��� �����ϱ� ���� Ŭ����
	// LoggerFactory.getLogger(class<T> clazz) : �޸𸮿� ����� Ŭ����(Clazz)���� �߻���
	// 		����� �α� ����ü���� �����ϴ� Logger �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
	private static final Logger logger= LoggerFactory.getLogger(LogHelloWorldApp.class);
	// ������ �����Ѵٰ� ��ϵǴ� ���� �ƴϴ�.
	// �̷��� Ŭ�������� �̺�Ʈ�� �߻���ų�״ϱ� ��� �� ����
	public static void main(String[] args) {
		// Logger.info(String message) : �α� �̺�Ʈ�� �߻��Ͽ� �α� ����ü���� �޼����� �����ϴ� �޼ҵ� => info������ �̺�Ʈ
		logger.info("����");
		LogHelloWorld hw= new LogHelloWorld();
		String message= hw.hello("ȫ�浿");
		System.out.println("message = "+message);
		logger.info("��");
	}
}
