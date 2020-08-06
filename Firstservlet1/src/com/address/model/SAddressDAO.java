package com.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class SAddressDAO {
	private static SAddressDAO instance = new SAddressDAO();
	
	public static SAddressDAO getInstance() {
		return instance;
	}
	
	//db����
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/member");
		
		return ds.getConnection();
	}
	
	//�˻� ����
	public int searchCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=getConnection();
			String sql="select count(*) from address where "+field+" like '%"+word+"%'";
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
	
	
	
	//�� ����
	public int addressCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=getConnection();
			String sql="select count(*) from address";
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
	
	
	
	//�߰�
	public void insertAddress(SAddressDTO sadd) {
		Connection con=null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "insert into address values(address_seq.nextval,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, sadd.getName());
			ps.setString(2, sadd.getZipcode());
			ps.setString(3, sadd.getTel());
			ps.setString(4, sadd.getAddr());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}
	}
	
	//����
	public void addressUpdate(SAddressDTO sadd) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "update address set name=?, zipcode=?, addr=?, tel=? where num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,sadd.getName());
			ps.setString(2,sadd.getZipcode());
			ps.setString(3,sadd.getAddr());
			ps.setString(4,sadd.getTel());
			ps.setInt(5,sadd.getNum());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
	}
	
	//�˻�
	public ArrayList<SAddressDTO> addressSearch(String field, String word) {
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<SAddressDTO> arr = new ArrayList<SAddressDTO>();
		
		try {
			con=getConnection();
			String sql = "select * from address where "+field+" like '%"+word+"%'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next()) {
				SAddressDTO dto = new SAddressDTO();
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getString("tel"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setNum(rs.getInt("num"));
				arr.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	
	//��ü����
		public ArrayList<SAddressDTO> addrList() throws Exception{
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
		    ArrayList<SAddressDTO> arr = new  ArrayList<SAddressDTO>();
		
			 try {			
					con=getConnection();
					String sql = "select* from address"; 
				
					st=con.createStatement();
					rs=st.executeQuery(sql);
					 
					 while(rs.next()) {
						 SAddressDTO sadd = new SAddressDTO();
						 sadd.setName(rs.getString("name"));
						 sadd.setAddr(rs.getString("addr"));
						 sadd.setZipcode(rs.getString("zipcode"));
						 sadd.setTel(rs.getString("tel"));
						 sadd.setNum(rs.getInt("num"));
						 arr.add(sadd);
			     		 
				 }	 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con,st,rs);
			}
			return arr;		 
		}
		
	//�󼼺���
		public SAddressDTO addressDetail(int num) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			SAddressDTO sadd = null;
			
			try {
				con=getConnection();
				String sql="select * from address where num="+num;
				st=con.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next()) {
					sadd=new SAddressDTO();
					sadd.setNum(rs.getInt("num"));
					sadd.setName(rs.getString("name"));
					sadd.setAddr(rs.getString("addr"));
					sadd.setTel(rs.getString("tel"));
					sadd.setZipcode(rs.getString("zipcode"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con,st, rs);
			}
			return sadd;
		}		
		
	//�����ϱ�	
		public void addressDelete(int num) {
			Connection con = null;
			Statement st = null;
			
			try {
				con=getConnection();
				String sql = "delete from address where num="+num;
				st=con.createStatement();
				st.executeUpdate(sql); //int ���� ��ȯ�Ǵµ�, ���� �����̸�1, ���и� 0��ȯ
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeConnection(con,st,null);
			}			
		}
		
		
	//�����ȣ
		public ArrayList<ZipcodeDTO> zipSearch(String dong) throws Exception{
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
		    ArrayList<ZipcodeDTO> arr = new  ArrayList<ZipcodeDTO>();
		    // <> : ���׸��̶� �θ�,,
			 try {			
				con=getConnection();
				String sql = "select* from zipcode where dong like '%"+dong+"%'"; 
							
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
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeConnection(con,st,rs);
			}
			return arr;		 
		}
		
	
		//�ݱ�
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

