
package xyz.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean Ŭ���� ������ ȣ�� ###");
	}
	
	// ��ü ���� �� �ʱ�ȭ �۾��� ���� �ѹ��� ȣ���ϱ� ���� �޼ҵ�
	public void init() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ init() �޼ҵ� ȣ�� ***");
	}
	
	// ��ü �Ҹ� �� ������ �۾��� ���� �ѹ��� ȣ���ϱ� ���� �޼ҵ�
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ destroy() �޼ҵ� ȣ�� ***");
	}
	
	public void display() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}
	
	// �ʱ�ȭ �ϴ� �������̵� �޾Ƽ� �ϴ� �޼ҵ���� ���� => �� �������̽� ���
	// init�� 12�� ���� destroy�� 1�� ����
}
