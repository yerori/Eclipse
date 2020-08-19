package org.addrMy.model;

public class AddressVO {
	private int num;
	private String addr;
	private String name;
	private String tel;
	private String zipcode;
	
	public int getNum() {
		return num ;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAddr() {
		return addr == null ? "" : addr.trim();
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel == null ? "" : tel.trim();
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getZipcode() {
		return zipcode == null ? "" : zipcode.trim();
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
