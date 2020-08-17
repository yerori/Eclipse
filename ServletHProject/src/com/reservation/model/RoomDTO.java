package com.reservation.model;

public class RoomDTO {
	private int rno;
	private String rname;
	private int tot_ad;
	private int tot_ch;
	private String price;
	private String rimage;
	private String startdate;
	private String enddate;	
	private String pay;
	private int rsno;
	private int occupancy;
	private int gno;
	private String id;

	
	public String getStartdate() {
		return startdate == null ? "" : startdate.trim();
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate == null ? "" : enddate.trim();
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getPay() {
		return pay == null ? "" : pay.trim();
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public int getRsno() {
		return rsno;
	}
	public void setRsno(int rsno) {
		this.rsno = rsno;
	}
	public int getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getId() {
		return id == null ? "" : id.trim();
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTot_ad() {
		return tot_ad;
	}
	public void setTot_ad(int tot_ad) {
		this.tot_ad = tot_ad;
	}
	public int getTot_ch() {
		return tot_ch;
	}
	public void setTot_ch(int tot_ch) {
		this.tot_ch = tot_ch;
	}

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
