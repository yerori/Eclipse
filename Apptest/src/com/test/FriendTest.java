package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import com.friend.Friend;
import com.friend.FriendDAOImpl;

public class FriendTest {
	//DB�����׽�Ʈ
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
	
	// �߰�test
	@Test
		public void insertTest() {
		FriendDAOImpl dao = new FriendDAOImpl();
		Friend f = new Friend();
		f.setAddr("�λ� ����");
		f.setName("ȫ�浿");
		f.setBirth("99999");
		f.setPhone("010546556465");
		dao.friendInsert(f);
		}
		
	//�󼼺��� �׽�Ʈ
	@Test
		public void detailTest() {
		FriendDAOImpl dao = new FriendDAOImpl();
		assertEquals("ȫ�浿",dao.friendDetail(35).getName());
	}
		
		//���� �׽�Ʈ
	@Test	
	public void updateTest() {
		FriendDAOImpl dao = new FriendDAOImpl();
		Friend f = new Friend();
		f.setName("������");
		f.setNum(4);
		dao.friendUpdate(f);
	}
		
		//���� �׽�Ʈ
	@Test
	public void deleteTest() {
		FriendDAOImpl dao = new FriendDAOImpl();
		dao.friendDelete(23);
	}
		
	}
	
	

