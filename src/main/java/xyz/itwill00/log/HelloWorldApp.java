package xyz.itwill00.log;

public class HelloWorldApp {
	public static void main(String[] args) {
		// �α׸� �Է��ϴ� ���α׷�(�α� ����ü)�� ���� �� 
		//  => �̷� ������ ���� �� ������־���Ѵ�.
		//  => ����� �ϱ� ���� ������� ���� ����ϴ� ������� ������ ��ƴ�.
		System.out.println("HelloWorldApp main �޼ҵ� ����");
		HelloWorld hw= new HelloWorld();
		String message= hw.hello("ȫ�浿");
		System.out.println("message= "+message);
		System.out.println("HelloWorldApp main �޼ҵ� ����");
	}
}
