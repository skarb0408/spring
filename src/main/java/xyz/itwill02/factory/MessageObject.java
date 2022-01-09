package xyz.itwill02.factory;

// 인터페이스를 상속받은 클래스가 반드시 선언해야하는 메소드를 추상메소드로 선언
//  => 인터페이스를 상속받은 클래스는 추상메소드를 무조건 오버라이드 선언해주어야한다.
//	=> 클래스의 작성 규칙이 정해진다. 모든 자식들은 같은 메소드를 상속받아야하기 때문에 형태가 똑같다.
// 인터페이스로 참조변수를 생성하면 모든 자식 인스턴스를 저장할 수 있다.
//  => 인터페이스의 참조변수로 메소드를 호출하면 오버라이드 선언된 자식 인스턴스의 메소드가 호출된다.
//  => 오버라이드에 의한 [다형성] => 객체 간의 결합도를 감소시킬 수 있다.
public interface MessageObject {
	String getMessage();
}
