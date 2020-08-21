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
		
		//예약 추가 
		public int resInsert(ReservationDTO res) {
			Connection con = null;
			PreparedStatement ps = null;	
			ResultSet rs = null;
			int flag=0;
			
			try {
				con=getConnection();
				String sql = "insert into reservation values"
						+ "(reservation_seq.nextval,?,?,?,TO_DATE(?,'YYYY-MM-DD'),TO_DATE(?,'YYYY-MM-DD'),?,?,?,?)";
				ps=con.prepareStatement(sql);
			
				ps.setInt(1, res.getOccupancy());
				ps.setInt(2, res.getTot_ad());
				ps.setInt(3, res.getTot_ch());
				ps.setString(4, res.getStartdate());
				ps.setString(5, res.getEnddate());
				ps.setString(6, res.getRname());
				ps.setInt(7, res.getGno());
				ps.setString(8, res.getId());
				ps.setString(9,res.getPay());
				flag = ps.executeUpdate();
				
				if(flag==1) {
					sql="select reservation_seq.CURRVAL from dual "; //CURRVAL : 시퀀스값 들고가긔
					ps = con.prepareStatement(sql);
					rs=ps.executeQuery();
					if(rs.next()) {
						flag=rs.getInt(1);
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, ps);
			}
			return flag;
		}
		
		
		
		//예약 상세보기 
		public ReservationDTO resDetail(int rsno) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			ReservationDTO dto = null;
					
			try {
				con=getConnection();
				String sql = "select * from reservation where rsno = "+rsno;
				st=con.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next()) {
					dto = new ReservationDTO();
					dto.setGno(rs.getInt("gno"));
					dto.setRsno(rs.getInt("rsno"));
					dto.setOccupancy(rs.getInt("occupancy"));
					dto.setTot_ad(rs.getInt("tot_ad"));
					dto.setTot_ch(rs.getInt("tot_ch"));
					dto.setStartdate(rs.getString("startdate").substring(0, 11)); //substring(a,b) : a부터 b까지 자르기
					dto.setEnddate(rs.getString("enddate").substring(0, 11));
					dto.setRname(rs.getString("rname"));
					dto.setId(rs.getString("id"));
					dto.setPay(rs.getString("pay"));
							
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st, rs);
			}
			return dto;
		}
				
		//예약 수정		
			
		public void resUpdate(ReservationDTO res) {
			Connection con = null;
			PreparedStatement ps = null;
					
			try {
				con=getConnection();
				String sql = "update reservation set occupancy=?, tot_ad=?, "
					+ "tot_ch=?, startdate=TO_DATE(?,'YYYY-MM-DD'), "
					+ "enddate=TO_DATE(?,'YYYY-MM-DD'), rname=?, "
					+ "gno=?, id=?, pay=? where rsno=?";
						
						
				ps=con.prepareStatement(sql);
						
				ps.setInt(1, res.getOccupancy());
				ps.setInt(2, res.getTot_ad());
				ps.setInt(3, res.getTot_ch());
				ps.setString(4, res.getStartdate());
				ps.setString(5, res.getEnddate());
				ps.setString(6, res.getRname());
				ps.setInt(7, res.getGno());
				ps.setString(8, res.getId());
				ps.setString(9, res.getPay());
				ps.setInt(10, res.getRsno());
					
				int flag = ps.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					closeConnection(con, ps);
			}
		}
				
			
		
		//예약 보기 
		public ArrayList<ReservationDTO> resList (){
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			ArrayList<ReservationDTO> arr = new ArrayList<ReservationDTO>();
					
			try {
				con=getConnection();
				String sql="select TO_CHAR(enddate,'YYYY-MM-DD'),rsno,occupancy,tot_ad,tot_ch,TO_CHAR(startdate,'YYYY-MM-DD'),rname,gno,id,pay "
						+ "from reservation order by rsno desc";
				st=con.createStatement();
				rs=st.executeQuery(sql);
						
				while(rs.next()) {
					ReservationDTO res = new ReservationDTO();
					res.setEnddate(rs.getString("enddate"));
					res.setRsno(rs.getInt("rsno"));
					res.setOccupancy(rs.getInt("occupancy"));
					res.setTot_ad(rs.getInt("tot_ad"));
					res.setTot_ch(rs.getInt("tot_ch"));
					res.setStartdate(rs.getString("startdate"));
					res.setRname(rs.getString("rname"));
					res.setGno(rs.getInt("gno"));
					res.setId(rs.getString("id"));
					res.setPay(rs.getString("pay"));
							
					arr.add(res);						
				}
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st, rs);
			}
			return arr;
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
				ps.setInt(2, room.getTot_ad());
				ps.setInt(3, room.getTot_ch());
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
		
		//방 개수 보기
		public ArrayList<RoomDTO> roomList (int startRow, int endRow){
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
					
			try {
				con=getConnection();
				String sql="select * from(select rownum rn,aa.* "
				+ "from(select * from room order by rno desc)aa) "
				+ "where rn<=? and rn>=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1,  endRow);
				ps.setInt(2, startRow);
				
				rs=ps.executeQuery();
						
				while(rs.next()) {
					RoomDTO room = new RoomDTO();
					room.setRno(rs.getInt("rno"));
					room.setRname(rs.getString("rname"));
					room.setTot_ad(rs.getInt("tot_ad"));
					room.setTot_ch(rs.getInt("tot_ch"));
					room.setPrice(rs.getString("price"));
					room.setRimage(rs.getString("rimage"));
					arr.add(room);						
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, ps, rs);
			}
			return arr;
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
					room.setTot_ad(rs.getInt("tot_ad"));
					room.setTot_ch(rs.getInt("tot_ch"));
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
					dto.setTot_ch(rs.getInt("tot_ch"));
					dto.setTot_ad(rs.getInt("tot_ad"));
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
				String sql = "update room set rname=?, tot_ad=?, tot_ch=?, price=?, rimage=? where rno=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, room.getRname());
				ps.setInt(2, room.getTot_ad());
				ps.setInt(3, room.getTot_ch());
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
		
				
		//방 개수 		
		public int roomCount() {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			int count = 0;
			
			try {
				con=getConnection();
				String sql = "select count(*) from room";
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
	
	
		//admin 리스트 보기 
		public ArrayList<AdminDTO> adminList (){
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			ArrayList<AdminDTO> arr = new ArrayList<AdminDTO>();
					
			try {
				con=getConnection();
				String sql="select * from reservation rs, room r where rs.rname = r.rname order by rsno desc";
				st=con.createStatement();
				rs=st.executeQuery(sql);
						
				while(rs.next()) {
					AdminDTO ad = new AdminDTO();
					ad.setEnddate(rs.getString("enddate").substring(0,11));
					ad.setGno(rs.getInt("gno"));
					ad.setId(rs.getString("id"));
					ad.setRno(rs.getInt("rno"));
					ad.setRname(rs.getString("rname"));
					ad.setTot_ad(rs.getInt("tot_ad"));
					ad.setTot_ch(rs.getInt("tot_ch"));
					ad.setPrice(rs.getString("price"));
					ad.setRimage(rs.getString("rimage"));
					ad.setOccupancy(rs.getInt("occupancy"));
					ad.setRsno(rs.getInt("rsno"));
					ad.setPay(rs.getString("pay"));
					ad.setStartdate(rs.getString("startdate").substring(0,11));
							
					arr.add(ad);						
				}						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st, rs);
			}
			return arr;
		}
		
		
		//페이징 예약 리스트 조회
		public ArrayList<AdminDTO> adminList (int startRow, int endRow){
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<AdminDTO> arr = new ArrayList<AdminDTO>();
					
			try {
				con=getConnection();
			//	String sql="select * from(select rownum rn,aa.* "
				//		+ "from(select * from room order by rno desc)aa) "
					//	+ "where rn<=? and rn>=?";
			//	String sql="select * from reservation rs, room r where rs.rname = r.rname order by rsno desc";
				
				String sql="select * from(select rownum rn,aa.* "
						+ "from(select rs.id, rs.rsno, rs.startdate,rs.enddate, rs.occupancy,rs.tot_ch,rs.tot_ad,r.price ,rs.rname from reservation rs, room r "
						+ "where rs.rname = r.rname order by rsno desc)aa) where rn<=? and rn>=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, endRow);
				ps.setInt(2, startRow);
			
				rs=ps.executeQuery();
						
				while(rs.next()) {
					AdminDTO ad = new AdminDTO();

					ad.setId(rs.getString("id"));
					ad.setRsno(rs.getInt("rsno"));
					ad.setStartdate(rs.getString("startdate").substring(0,11));
					ad.setEnddate(rs.getString("enddate").substring(0,11));
					ad.setOccupancy(rs.getInt("occupancy"));
					ad.setTot_ch(rs.getInt("tot_ch"));
					ad.setTot_ad(rs.getInt("tot_ad"));
					ad.setPrice(rs.getString("price"));
					ad.setRname(rs.getString("rname"));

					arr.add(ad);						
				}						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, ps, rs);
			}
			return arr;
		}
		
		//admin 리스트 삭제하기
		public void adminDelete(int rsno) {
			Connection con = null;
			Statement st = null;
			
			try {
				con=getConnection();
				String sql = "delete from reservation where rsno = "+rsno;
				st=con.createStatement();
				st.executeUpdate(sql);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st, null);
			}			
		}
		
		
		//admin 리스트 상세보기
		public AdminDTO adminDetail(int rsno) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			AdminDTO dto = null;
			
			try {
				con=getConnection();
			//	"select * from room where rno = "+rno;				
				
				String sql = "select * from reservation rs, room r where rsno = "+rsno;
				st=con.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next()) {
					dto = new AdminDTO();
					dto.setTot_ch(rs.getInt("tot_ch"));
					dto.setTot_ad(rs.getInt("tot_ad"));
					dto.setPrice(rs.getString("price"));
					dto.setRimage(rs.getString("rimage"));
					dto.setRname(rs.getString("rname"));
					dto.setRno(rs.getInt("rno"));
					dto.setEnddate(rs.getString("enddate"));
					dto.setStartdate(rs.getString("startdate"));
					dto.setGno(rs.getInt("gno"));
					dto.setId(rs.getString("id"));
					dto.setOccupancy(rs.getInt("occupancy"));
					dto.setPay(rs.getString("pay"));
					dto.setRsno(rs.getInt("rsno"));	
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st, rs);
			}
			return dto;
		}
		
		
		
		//총 예약 개수 
		public int resCount() {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			int count = 0;
			
			
			try { 
				con = getConnection();
				st = con.createStatement();
				String sql ="select count(*) from reservation rs, room r where rs.rname = r.rname";
				rs = st.executeQuery(sql);
				if(rs.next()) {
					count = rs.getInt(1);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
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
