package xyz.itwill01.old;

public class HiMessagePrint {
	public void hiPrint() {
		HiMessageObject object= new HiMessageObject();
		String message= object.getHiMessage();
		System.out.println("message = "+message);
	}
}
