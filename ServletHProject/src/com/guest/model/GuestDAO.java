package com.guest.model;

import java.util.ArrayList;

public interface GuestDAO {
	//���� �߰�
	public void guestInsert(GuestDTO guest);
	
	
	//���� ����
	public void guestUpdate(GuestDTO guest);
	
	
	//��ü����
	public ArrayList<GuestDTO> guestList();
	
	
	
	//�󼼺���
	public GuestDTO guestView(int num); 
	
	
	//�α���üũ
	public GuestDTO guestLoginChk(String id, String pwd);
}
