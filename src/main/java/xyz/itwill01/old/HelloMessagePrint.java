package xyz.itwill01.old;

public class HelloMessagePrint {
	public void helloPrint() {
		HelloMessageObject object= new HelloMessageObject();
		String message= object.getHelloMessage();
		System.out.println("message = "+message);
	}
}
