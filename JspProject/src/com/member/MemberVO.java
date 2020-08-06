package com.member;

 //1. ∆˚¿€º∫ 2. src≥ª com.øıæﬁ ∆–≈∞¡ˆ ∏∏µÍ Vo∏∏µÍ 3. DAO ¿Œ≈Õ∆‰¿ÃΩ∫ ∏∏µÍ 4. DAO ≈¨∑°Ω∫ ∏∏µÍ 
public class MemberVO {
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
