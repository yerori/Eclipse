package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import com.friend.Friend;
import com.friend.FriendDAOImpl;

public class FriendTest {
	//DB연동테스트
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER="scott";
	private static final String PW = "1234";
		
	@Test
		public void FriendTest() throws Exception{
			Class.forName(DRIVER);
			try(Connection con = DriverManager.getConnection(URL,USER,PW)){
				System.out.println(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	// 추가test
	@Test
		public void insertTest() {
		FriendDAOImpl dao = new FriendDAOImpl();
		Friend f = new Friend();
		f.setAddr("부산 서면");
		f.setName("홍길동");
		f.setBirth("99999");
		f.setPhone("010546556465");
		dao.friendInsert(f);
		}
		
	//상세보기 테스트
	@Test
		public void detailTest() {
		FriendDAOImpl dao = new FriendDAOImpl();
		assertEquals("홍길동",dao.friendDetail(35).getName());
	}
		
		//수정 테스트
	@Test	
	public void updateTest() {
		FriendDAOImpl dao = new FriendDAOImpl();
		Friend f = new Friend();
		f.setName("강감찬");
		f.setNum(4);
		dao.friendUpdate(f);
	}
		
		//삭제 테스트
	@Test
	public void deleteTest() {
		FriendDAOImpl dao = new FriendDAOImpl();
		dao.friendDelete(23);
	}
		
	}
	
	

