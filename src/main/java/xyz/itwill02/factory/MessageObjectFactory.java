package xyz.itwill02.factory;

// Factory ������ ������ ����� Ŭ���� - Factory Ŭ����(�����) �Ǵ� Provider Ŭ����(����)
//  => �ν��Ͻ�(��ü)�� �����Ͽ� ��ȯ�ϴ� ����� �����ϴ� Ŭ����
//  => ��ü�� ��� ����� �������ش�.(��Ḧ �޾Ƽ� ����� �ִ� ���� ����)
public class MessageObjectFactory {
	// �ν��Ͻ��� �ϳ��� ���� �Ǳ� ������ �̱��� Ŭ������ ����
	private static MessageObjectFactory _factory;
	
	//��ȯ�Ǵ� ��ü Ÿ���� �����ϱ� ���� ��� ����
	public final static int HELLO_MESSAGE=1; 
	public final static int HI_MESSAGE=2; 
	
	private MessageObjectFactory() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_factory= new MessageObjectFactory();
	}
	
	public static MessageObjectFactory getFactory() {
		return _factory;
	}
	
	// �߿�
	// �������� ���޹޾� ���Ͽ� �������̽��� ��ӹ��� �ڽ� Ŭ������ �ν��Ͻ��� �����Ͽ�
	// ��ȯ�ϴ� �޼ҵ�
	public MessageObject getMessageObject(int messageObject) {
		MessageObject object= null;
		switch(messageObject) {
		case HELLO_MESSAGE:
			object= new HelloMessageObject();
		case HI_MESSAGE:
			object= new HiMessageObject();
		}
		return object;
	}
}
