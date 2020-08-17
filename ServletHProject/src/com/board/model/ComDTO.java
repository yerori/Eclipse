package com.board.model;

public class ComDTO {
	private int cnum;
	private String content;
	private String email;
	private String subject;
	private String id;
	

	public String getId() {
		return id == null ? "" : id.trim();
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCnum() {
		return cnum ;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getContent() {
		return content == null ? "" : content.trim();
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email == null ? "" : email.trim();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject == null ? "" : subject.trim();
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
