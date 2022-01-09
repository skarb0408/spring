package xyz.itwill04.bean;

// �̱��� ������ ������ ����� Ŭ���� - �̱��� Ŭ����(Singleton Class)
public class FactoryMethodBean {
	private static FactoryMethodBean _bean;
	
	private FactoryMethodBean() {
		System.out.println("### FactoryMethodBean Ŭ���� �⺻ ������ ȣ��");
	}
	
	static {
		_bean= new FactoryMethodBean();
	}
	
	public static FactoryMethodBean getFactoryMethodBean() {
		System.out.println("*** FactoryMethodBean Ŭ������ getFactoryMethodBean() �޼ҵ� ȣ�� ***");
		return _bean;
	}
}
