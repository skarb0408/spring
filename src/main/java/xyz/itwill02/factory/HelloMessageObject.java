package xyz.itwill02.factory;

public class HelloMessageObject implements MessageObject {
	
	/*
	public String getHelloMessage() { return "ㅎㅇㅎㅇ"; }
	맘대로 만드는 것이 아닌 오버라이드 해주어야한다.
	 */
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "ㅎㅇㅎㅇ";
	}
}
