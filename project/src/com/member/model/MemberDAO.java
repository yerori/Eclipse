package com.member.model;

import java.util.ArrayList;


public interface MemberDAO {
	//�߰� : �������̽��� ����x �̸��� ����
		public void memberInsert(MemberDTO vo);

		
		//��ü����
		public ArrayList<MemberDTO> memberList();
		
		//����
		public int memberUpdate(MemberDTO vo);
		
		//�󼼺���
		public MemberDTO memberView(String userid);
		
		//����
		public void memberDel(String userid);
		
		//���̵�üũ(�ߺ�)
		public String idCheck(String userid);
}
