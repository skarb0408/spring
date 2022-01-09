package xyz.itwill10.dto;

// create table pointboard(num number PRIMARY key, writer VARCHAR2(20), subject VARCHAR2(100));

/*
이름      널?       유형            
------- -------- ------------- 
NUM     NOT NULL NUMBER        primary key
WRITER           VARCHAR2(20)  
SUBJECT          VARCHAR2(100) 
 */

public class PointBoard {
	private int num;
	private String writer;
	private String subject;
	
	public PointBoard() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
