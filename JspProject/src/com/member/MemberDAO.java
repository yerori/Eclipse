package com.member;


import java.util.ArrayList;

public interface MemberDAO {
	
	//�߰� : �������̽��� ����x �̸��� ����
	public void memberInsert(MemberVO vo);

	
	//��ü����
	public ArrayList<MemberVO> memberList();
	
	//����
	public int memberUpdate(MemberVO vo);
	
	//�󼼺���
	public MemberVO memberView(String userid);
	
	//����
	public void memberDel(String userid);
	
	//���̵�üũ(�ߺ�)
	public String idCheck(String userid);
}
