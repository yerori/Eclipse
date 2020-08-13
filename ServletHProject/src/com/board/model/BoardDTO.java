package com.board.model;

public class BoardDTO {
	private int num;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private int ref; //그룹
	private int re_step; //그룹내 순서
	private int re_level; //그룹들여쓰기
	private String reg_date;//작성일
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer == null ? "" : writer.trim();
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject == null ? "" : subject.trim();
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email == null ? "" : email.trim();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content == null ? "" : content.trim();
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public String getReg_date() {
		return reg_date == null ? "" : reg_date.trim();
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

}
