package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAOImpl {

	//DB연동
	private static BoardDAOImpl instance = new BoardDAOImpl();
	public static BoardDAOImpl getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/member");
		return ds.getConnection();
	}
	
	
	//콘택트 추가
	public int contactInsert(ComDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="";
		int flag=0;
		try {
			con=getConnection();
			 sql="insert into contact values(content_seq.nextval,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getContent());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getSubject());

			
			 flag=ps.executeUpdate();
			if(flag ==1) {
				sql ="select  content_seq.CURRVAL from dual";	 //시퀀스값 들고가기 위한 코드
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					flag = rs.getInt(1);					
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
		System.out.println("flag : " + flag);
		return flag;
	}
	
	
	//contact 조회 보기(상세보기)
	public ComDTO contactDetail(int cnum) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ComDTO dto = null;
		
		try {
			con=getConnection();
			String sql = "select * from contact where cnum="+cnum;
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				dto = new ComDTO();
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setEmail(rs.getString("email"));
				dto.setSubject(rs.getString("subject"));
				dto.setCnum(rs.getInt("cnum"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st,rs);
		}
		return dto;
	}
	
	
	//contact 수정
	public void contentUpdate(ComDTO com) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql="update contact set content=?, id=?, email=?, subject=? where cnum=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, com.getContent());
			ps.setString(2, com.getId());
			ps.setString(3, com.getEmail());
			ps.setString(4, com.getSubject());
			ps.setInt(5, com.getCnum());
	
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
	}
	
	//contact 전체보기 
	
	public ArrayList<ComDTO> contentList(){
		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		ArrayList<ComDTO> arr= new ArrayList<ComDTO>();
	
		
		try {
			con=getConnection();
			String sql = "select * from contact";
		
			st=con.createStatement();			
			rs=st.executeQuery(sql);
		
			while(rs.next()) {
				ComDTO dto = new ComDTO();
				dto.setCnum(rs.getInt("cnum"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				arr.add(dto);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}
	
	
	
	
	//contact 전체보기 (개수)
	public ArrayList<ComDTO> contentList(int startRow, int endRow){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ComDTO> arr= new ArrayList<ComDTO>();
	
		
		try {
			con=getConnection();
			String sql = "select * from(select rownum rn,aa.* "
					+ "from(select * from contact order by cnum desc)aa) "
					+ "where rn<=? and rn>=?";		//as
		
			ps=con.prepareStatement(sql);
			ps.setInt(1,  endRow);
			ps.setInt(2, startRow);
			
			rs=ps.executeQuery();
		
			while(rs.next()) {
				ComDTO dto = new ComDTO();
				dto.setCnum(rs.getInt("cnum"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				arr.add(dto);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, rs);
		}
		return arr;
	}
	
	//contact 개수 
	public int contactCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con=getConnection();
			String sql = "select count(*) from contact";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
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
	
	
	//contact 삭제
	public void contactDelete(int cnum) {
		Connection con = null;
		Statement st = null;
		
		try {
			con=getConnection();
			String sql="delete from contact where cnum="+cnum;
			st=con.createStatement();
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, null);
		}
	}
	
	//룸 추가
	
	
	
	
	
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
