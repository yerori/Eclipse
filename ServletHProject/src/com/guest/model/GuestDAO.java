package com.guest.model;

import java.util.ArrayList;

public interface GuestDAO {
	//계정 추가
	public void guestInsert(GuestDTO guest);
	
	
	//계정 수정
	public void guestUpdate(GuestDTO guest);
	
	
	//전체보기
	public ArrayList<GuestDTO> guestList();
	
	
	
	//상세보기
	public GuestDTO guestView(int num); 
	
	
	//로그인체크
	public GuestDTO guestLoginChk(String id, String pwd);
}
