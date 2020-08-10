package com.guest.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class GuestDAOImpl implements GuestDAO {


	//DB연동
	private static GuestDAOImpl instance = new GuestDAOImpl();
	public static GuestDAOImpl getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/guest");
		return ds.getConnection();
	}
	
	
	//계정 추가
	public void guestInsert(GuestDTO guest) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql="insert into guest values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, guest.getId());
			ps.setString(2, guest.getPwd());
			ps.setString(3, guest.getPwd_chk());
			ps.setString(4, guest.getAddress());
			ps.setString(5, guest.getPhone());
			ps.setString(6, guest.getEmail());
			ps.setInt(7, guest.getAdmin());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}			
	}

	//계정 수정
	public void guestUpdate(GuestDTO guest) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<GuestDTO> guestList() {
		// TODO Auto-generated method stub
		return null;
	}

	public GuestDTO guestView(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public int guestLoginChk(String id, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int flag=-1; //회원이 아닐 시
		
		try {
			con=getConnection();
			String sql="select * from guest where id='"+id+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					flag=rs.getInt("admin");
				}else {
					flag=2;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return flag;
	}
 
	
	//닫기	
	private void closeConnection(Connection con, PreparedStatement ps) {	
		try {
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void closeConnection(Connection con, Statement st,ResultSet rs) {
		
		try {
			if(st!=null) st.close();
			if(con!=null) con.close();
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
