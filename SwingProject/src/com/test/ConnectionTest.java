package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import com.model.FriendDAOImpl;

public class ConnectionTest {

	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER="scott";
	
	private static final String PW = "1234";
	
	
	@Test // @ : ������̼� ,, // Junit�� �������� �������� 
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection con = DriverManager.getConnection(URL,USER,PW)){
			//try���� if�� ó�� () �ؼ� �ȿ� ���� ����
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
