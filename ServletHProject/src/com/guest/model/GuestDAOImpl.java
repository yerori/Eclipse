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

import com.reservation.model.ReservationDTO;
import com.reservation.model.RoomDTO;


public class GuestDAOImpl implements GuestDAO {


	//DB연동
	private static GuestDAOImpl instance = new GuestDAOImpl();
	public static GuestDAOImpl getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/member");
		return ds.getConnection();
	}
	
	
	//계정 추가
	public void guestInsert(GuestDTO guest) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql="insert into member values(MEM_SEQ.nextval,?,?,?,?,?,0)";
			ps=con.prepareStatement(sql);
			ps.setString(1, guest.getId());
			ps.setString(2, guest.getPwd());
			ps.setString(3, guest.getAddress());
			ps.setString(4, guest.getPhone());
			ps.setString(5, guest.getEmail());
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

	//계정 list
	public ArrayList<GuestDTO> guestList() {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			ArrayList<GuestDTO> arr = new ArrayList<GuestDTO>();
			
			try {
				con=getConnection();
				String sql="select * from member";
				st=con.createStatement();
				rs=st.executeQuery(sql);
				
				while(rs.next()) {
					GuestDTO guest = new GuestDTO();
					guest.setId(rs.getString("id"));
					guest.setPwd(rs.getString("pwd"));
					guest.setAddress(rs.getString("address"));
					guest.setPhone(rs.getString("phone"));
					guest.setEmail(rs.getString("email"));
					guest.setGno(rs.getInt("gno"));
					guest.setAdmin(rs.getInt("admin"));
					
					arr.add(guest);						
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st, rs);
			}
			return arr;
		}
	

	public GuestDTO guestView(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	//id체크
	//0이면 일반회원, 1이면 관리자 -1이면 회원x
	public String idCheck(String id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String flag="yes";
		
		try {
			con=getConnection();
			String sql = "select* from member where id='"+id+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				flag="no";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return flag;
	}
	
	//로그인 체크
	
	public GuestDTO guestLoginChk(String id, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		GuestDTO guest =new GuestDTO(); 
		
		try {
			con=getConnection();
			String sql="select * from member where id='"+id+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) { //회원일 시
				
				if(rs.getString("pwd").equals(pwd)) {
					guest.setAdmin(rs.getInt("admin")); //관리자
					guest.setId(rs.getString("id"));  //회원
					guest.setGno(rs.getInt("gno")); //gno
				}else if (rs.getString("pwd")!=pwd){
					guest.setAdmin(2); //회원인데 비밀번호 오류
				}
				
			}else { //회원이 아닐 시 
				guest.setAdmin(-1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return guest;
	}
 
	//우편번호
	public ArrayList<ZipcodeDTO> zipSearch(String dong){
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipcodeDTO> arr = new ArrayList<ZipcodeDTO>();
		
		try {
			con=getConnection();
			String sql = "select * from zipcode where dong like '%"+dong+"%'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next()) {
				ZipcodeDTO zip = new ZipcodeDTO();
				zip.setBunji(rs.getString("bunji"));
				zip.setDong(rs.getString("dong"));
				zip.setGugun(rs.getString("gugun"));
				zip.setSido(rs.getString("sido"));
				zip.setZipcode(rs.getString("zipcode"));
				
				arr.add(zip);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return arr;
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
