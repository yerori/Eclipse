package com.member.model;

import java.util.ArrayList;


public interface MemberDAO {
	//추가 : 인터페이스라 구현x 이름만 정의
		public void memberInsert(MemberDTO vo);

		
		//전체보기
		public ArrayList<MemberDTO> memberList();
		
		//수정
		public int memberUpdate(MemberDTO vo);
		
		//상세보기
		public MemberDTO memberView(String userid);
		
		//삭제
		public void memberDel(String userid);
		
		//아이디체크(중복)
		public String idCheck(String userid);
}
