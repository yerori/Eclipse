package com.reservation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.board.model.BoardDAOImpl;

public class ReservationDAOImpl {
	//DB연동
		private static ReservationDAOImpl instance = new ReservationDAOImpl();
		public static ReservationDAOImpl getInstance() {
			return instance;
		}
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/member");
			return ds.getConnection();
		}
		
		//방 추가
		public void roomInsert(RoomDTO room) {
			Connection con=null;
			PreparedStatement ps = null;
			
			try {
				con=getConnection();
				String sql = "insert into room values(room_seq.nextval,?,?,?,?,?)";
				ps=con.prepareStatement(sql);
				
				ps.setString(1, room.getRname());
				ps.setInt(2, room.getMen());
				ps.setInt(3, room.getBaby());
				ps.setString(4, room.getPrice());
				ps.setString(5, room.getRimage());
				ps.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, ps);
			}
			
		}
		
		
		//방 보기 
		public ArrayList<RoomDTO> roomList (){
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
			
			try {
				con=getConnection();
				String sql="select * from room";
				st=con.createStatement();
				rs=st.executeQuery(sql);
				
				while(rs.next()) {
					RoomDTO room = new RoomDTO();
					room.setRno(rs.getInt("rno"));
					room.setRname(rs.getString("rname"));
					room.setMen(rs.getInt("men"));
					room.setBaby(rs.getInt("baby"));
					room.setPrice(rs.getString("price"));
					room.setRimage(rs.getString("rimage"));
					arr.add(room);						
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st, rs);
			}
			return arr;
		}
		
		
		//방 상세보기 
		public RoomDTO roomDetail(int rno) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			RoomDTO dto = null;
			
			try {
				con=getConnection();
				String sql = "select * from room where rno = "+rno;
				st=con.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next()) {
					dto = new RoomDTO();
					dto.setBaby(rs.getInt("baby"));
					dto.setMen(rs.getInt("men"));
					dto.setPrice(rs.getString("price"));
					dto.setRimage(rs.getString("rimage"));
					dto.setRname(rs.getString("rname"));
					dto.setRno(rs.getInt("rno"));
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st, rs);
			}
			return dto;
		}
		
		
		//방 수정
		public void roomUpdate(RoomDTO room) {
			Connection con = null;
			PreparedStatement ps = null;
			
			
			try {
				con=getConnection();
				String sql = "update room set rname=?, men=?, baby=?, price=?, rimage=? where rno=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, room.getRimage());
				ps.setInt(2, room.getMen());
				ps.setInt(3, room.getBaby());
				ps.setString(4, room.getPrice());
				ps.setString(5, room.getRimage());
				ps.setInt(6, room.getRno());
				ps.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, ps);
			}
			
		}
		
		//방삭제
		public void roomDelete(int rno) {
			Connection con = null;
			Statement st = null;
			
			try {
				con=getConnection();
				String sql = "delete from room where rno="+rno;
				st=con.createStatement();
				st.executeUpdate(sql);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st, null);
			}
			
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
