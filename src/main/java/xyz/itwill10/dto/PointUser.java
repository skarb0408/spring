package xyz.itwill10.dto;

// create table pointuser(id VARCHAR2(20) PRIMARY KEY, name VARCHAR2(30), point number);

/*
	이름    널?       유형           
----- -------- ------------ 
ID    NOT NULL VARCHAR2(20) 
NAME           VARCHAR2(30) 
POINT          NUMBER      
 */

public class PointUser {
	private String id;
	private String name;
	private int point;
	
	public PointUser() {
		// TODO Auto-generated constructor stub
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
