package xyz.itwill10.dto;

// JavaBean Ŭ���� :  ���ް��� �����ϱ� ���� Ŭ����
//  => DAO Ŭ�������� ����� ��� DTO Ŭ���� ��Ȱ ����
// ���ް��� �̸��� ������ �̸��� �ʵ� ���� >> ���ް��� �ʵ忡 �ڵ� ���� : Setter �޼ҵ�
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
