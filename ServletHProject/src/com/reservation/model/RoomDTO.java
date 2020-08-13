package com.reservation.model;

public class RoomDTO {
	private int rno;
	private String rname;
	private int men;
	private int baby;	
	private String price;
	private String rimage;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRname() {
		return rname == null ? "" : rname.trim();
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getMen() {
		return men;
	}
	public void setMen(int men) {
		this.men = men;
	}
	public int getBaby() {
		return baby;
	}
	public void setBaby(int baby) {
		this.baby = baby;
	}
	public String getPrice() {
		return price == null ? "" : price.trim();
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRimage() {
		return rimage == null ? "" : rimage.trim();
	}
	public void setRimage(String rimage) {
		this.rimage = rimage;
	}
	
	
}
