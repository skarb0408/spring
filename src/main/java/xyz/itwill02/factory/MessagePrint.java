package xyz.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
		//MessageObject object= MessageObjectFactory.getFactory()
			//	.getMessageObject(MessageObjectFactory.HELLO_MESSAGE);
		
		MessageObject object= MessageObjectFactory.getFactory()
					.getMessageObject(MessageObjectFactory.HI_MESSAGE);
		
		// �������̽��� ���������� �̿��Ͽ� �޼ҵ带 ȣ���� ��� ���������� 
		// 		����� �ڽ� �ν��Ͻ��� �������̵� �޼ҵ� ȣ�� => �������̵忡 ���� ������
		String message= object.getMessage();
		System.out.println("message = "+message);
	}
}
