package xyz.itwill09.mvc;

// 결과값을 저장할 클래스
public class Member {
	private String id;
	private String name;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
