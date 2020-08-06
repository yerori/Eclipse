package com.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.model.Friend;
import com.model.FriendDAOImpl;

public class DetailTest {
	
	// 단위 테스트 !!
	// 전체 입력 후, 테스트가 아니라 하나하나 테스트하는것이 오류가 덜함 ,, 
	
	@Test
	public void detailFriend() {
	FriendDAOImpl dao = new FriendDAOImpl();
	assertEquals("asdf", dao.friendDetail(19).getName()); //friendDelete 메소드에 19번을 넣으면 asdf가 나온다.
	
	}
	@Test
	public void friendInsert() {
		FriendDAOImpl dao = new FriendDAOImpl();
		Friend f = new Friend();
		f.setAddr("addrTest");
		f.setBirth("20200706");
		f.setName("test");
		f.setPhone("010");
		dao.friendInsert(f);
	}
	
	@Test
	public void friendDelete() {
		FriendDAOImpl dao = new FriendDAOImpl();
		dao.friendDelete(27);
		dao.friendDelete(28);
		dao.friendDelete(29);
	}
	
	
	
}
