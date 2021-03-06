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

public class GuestDAO {
	
	
	//db세팅
private static GuestDAO instance = new GuestDAO();
	
	public static GuestDAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception{
		Context iniCtx = new InitialContext();
		Context envCtx = (Context) iniCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/guest");
		return ds.getConnection();
	}
	
	
	//추가	
	public void guestInsert(GuestDTO guest) throws Exception {
		Connection con=null;
		PreparedStatement ps = null;		
		
		try {
			con=getConnection();		// ★ sql문 어려웠다 ㅠ_ㅠ → 입력하는 값이 3개밖에 없고, ip주소는 내가 입력하는게 아님!!
			String sql="insert into guestbook values(guestbook_seq.nextval,?,?,?,sysdate,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, guest.getName());
			ps.setString(2, guest.getContent());
			ps.setString(3, guest.getGrade());
			ps.setString(4, guest.getIpaddr());
			ps.executeUpdate(); //ps.execute() 적어도 상관 x
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);		
		}
	}
	
	//삭제
	public void guestDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con=getConnection();
			String sql = "delete from guestbook where num="+num;
				//	+ " && name='"+name+"'";
			st=con.createStatement();
			st.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st,null);
		}
		
	}
	
	
		//로그인 체크
		//회원 아님 : -1 	회원 일 때:1 	회원이지만, 비밀번호 오류 : 0
		public int guestLoginCheck(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int flag = -1; //회원이 아님
		
		try {
			con=getConnection();	//pwd, userid 변수는 member에만 존재
			String sql = "select pwd from member where userid='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) { //회원임
				if(rs.getString("pwd").equals(pwd)) {//회원이 맞을 경우~!
					flag=1; //회원이다 = 1
				}else {
					flag=0; //회원인데, 비번 오류
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
	
	
	//전체보기 페이지 
	public ArrayList<GuestDTO> guestList(int startRow, int endRow) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<GuestDTO> arr = new ArrayList<>();	
		
		try {
			con=getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select * from");
			sb.append(" (select aa.*, rownum rn from");
			sb.append(" (select * from guestbook order by num desc) aa");
			sb.append(" where rownum<=? ) where rn>=?");
			
			ps=con.prepareStatement(sb.toString());	
			ps.setInt(1,endRow);
			ps.setInt(2,startRow);	
			rs=ps.executeQuery();
			
			 while(rs.next()) {
				 GuestDTO guest = new GuestDTO();
				 guest.setContent(rs.getString("content"));
				 guest.setCreated(rs.getString("created"));
				 guest.setGrade(rs.getString("grade"));
				 guest.setIpaddr(rs.getString("ipaddr"));
				 guest.setName(rs.getString("name"));
				 guest.setNum(rs.getInt("num"));
				 arr.add(guest);
			 }		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(con, ps, rs);
		}		
		return arr;
	}
	
	//검색시 : 전체보기 페이지 
		public ArrayList<GuestDTO> guestList(String field, String word, int startRow, int endRow) throws Exception{
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<GuestDTO> arr = new ArrayList<>();	
			
			try {
				con=getConnection();
				StringBuilder sb = new StringBuilder();
				sb.append("select * from");
				sb.append(" (select aa.*, rownum rn from"); 	//like 앞 뒤로 띄우기
				sb.append(" (select * from guestbook where "+field+" like '%"+word+"%'");
				sb.append(" order by num desc) aa");
				sb.append(" where rownum<=? ) where rn>=?");
				
				ps=con.prepareStatement(sb.toString());	
				ps.setInt(1,endRow);
				ps.setInt(2,startRow);	
				rs=ps.executeQuery();
				
				 while(rs.next()) {
					 GuestDTO guest = new GuestDTO();
					 guest.setContent(rs.getString("content"));
					 guest.setCreated(rs.getString("created"));
					 guest.setGrade(rs.getString("grade"));
					 guest.setIpaddr(rs.getString("ipaddr"));
					 guest.setName(rs.getString("name"));
					 guest.setNum(rs.getInt("num"));
					 arr.add(guest);
				 }		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				closeConnection(con, ps, rs);
			}		
			return arr;
		}
		
		
	
	//전체보기
	public ArrayList<GuestDTO> guestList() throws Exception{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<GuestDTO> arr = new ArrayList<>();	
		
		try {
			con=getConnection();
			String sql="select * from guestbook order by num asc";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			 while(rs.next()) {
				 GuestDTO guest = new GuestDTO();
				 guest.setContent(rs.getString("content"));
				 guest.setCreated(rs.getString("created"));
				 guest.setGrade(rs.getString("grade"));
				 guest.setIpaddr(rs.getString("ipaddr"));
				 guest.setName(rs.getString("name"));
				 guest.setNum(rs.getInt("num"));
				 arr.add(guest);
			 }		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(con, st, rs);
		}		
		return arr;
	}
	
	
	//상세보기
	public GuestDTO guestView(int num){
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		GuestDTO dto = null;
		
		try {
			con=getConnection();
			String sql = "select * from guestbook where num="+num;
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				dto = new GuestDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setCreated(rs.getString("created"));
				dto.setGrade(rs.getString("grade"));
				dto.setIpaddr(rs.getString("ipaddr"));
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return dto;
	}
	
	//개수
	public int getCount(String field, String word) {
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		String sql="";
		
		try {
			con=getConnection();
			if(word.equals("")) {
				sql = "select count(*) from guestbook";
			}
			else {
				sql= "select count(*) from guestbook where "+field +" like '%"+word+"%'";
			}
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return count;
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
