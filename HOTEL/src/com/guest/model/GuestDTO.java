package com.guest.model;

public class GuestDTO {

	private String id;
	private String pwd;
	private String pwd_chk;
	private String address;
	private String phone;
	private int admin;
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getAddress() {
		return address == null ? "" : address.trim();
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String email;
	

	public String getId() {
		return id == null ? "" : id.trim();
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd == null ? "" : pwd.trim();
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd_chk() {
		return pwd_chk == null ? "" : pwd_chk.trim();
	}
	public void setPwd_chk(String pwd_chk) {
		this.pwd_chk = pwd_chk;
	}
	public String getPhone() {
		return phone == null ? "" : phone.trim();
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email == null ? "" : email.trim();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
