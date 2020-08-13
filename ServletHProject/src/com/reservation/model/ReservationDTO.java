package com.reservation.model;

public class ReservationDTO {
	private int rsno;
	private int rno;
	private int occupancy; //예약된 날짜
	private int tot_ad;
	private int tot_ch;
	private int gno;
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}

	private String startdate;
	private String enddate;
	
	public int getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	private String rname;
	
	public String getRname() {
		return rname == null ? "" : rname.trim();
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRsno() {
		return rsno ;
	}
	public void setRsno(int rsno) {
		this.rsno = rsno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
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
	
	
}
