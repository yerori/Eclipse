package com.jqueryAddress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JAddressDAO {
	
	// 할 때마다 생성(new 웅앵) 하지 않기 위해 static으로 지정
	// static 한번 선언하면 덜번거로우니까~!
	private static JAddressDAO instance = new JAddressDAO(); 
	
	public static JAddressDAO getInstance() {
		return instance;
	}	
	
	//db연결
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		
		return ds.getConnection();
	}
	
	
	
	//추가
	public void addrInsert(Address ad) {
		Connection con=null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "insert into address values(address_seq.nextval,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, ad.getName());
			ps.setString(2, ad.getZipcode());
			ps.setString(3, ad.getTel());
			ps.setString(4, ad.getAddr());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}
	}
	
	
	
	//수정
	public void addrUpdate(Address ad) {
		Connection con=null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "Update address set name=?, zipcode=?, tel=?, addr=? where num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, ad.getName());
			ps.setString(2, ad.getZipcode());
			ps.setString(3, ad.getTel());
			ps.setString(4, ad.getAddr());
			ps.setLong(5, ad.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con,ps);
		}
	}
	
	public int getCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=getConnection();
		
			String sql="select count(*) from address";
		
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			} // 첫번째 열 값의 갯수를 int로 불러와라 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,st,rs);
		}
		return count;
	}
	
	// 행 개수 구하기
	public int getCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=getConnection();
			String sql="select count(*) from address where "+field+" like '%"+word+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			} // 첫번째 열 값의 갯수를 int로 불러와라 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,st,rs);
		}
		return count;
	}	
	
	//전체보기 검색 아님 
	public ArrayList<Address> addrList() throws Exception{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
	    ArrayList<Address> arr = new  ArrayList<Address>();
		 try {			
			con=getConnection();
			
				String	sql = "select* from address"; 
			
				st=con.createStatement();
				rs=st.executeQuery(sql);
				 
				 while(rs.next()) {
					 Address ad = new Address();
					 ad.setName(rs.getString("name"));
					 ad.setAddr(rs.getString("addr"));
					 ad.setZipcode(rs.getString("zipcode"));
					 ad.setTel(rs.getString("tel"));
					 ad.setNum(rs.getLong("num"));
					 arr.add(ad);		     		 
			 }	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;		 
	}
	
		
	//전체보긩 검색
	public ArrayList<Address> addrList(String field, String word) throws Exception{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
	    ArrayList<Address> arr = new  ArrayList<Address>();
	    	try {			
				con=getConnection();
				String sql="select* from address where "+field+" like '%"+word+"%'";
				st=con.createStatement();
				rs=st.executeQuery(sql);
				 
			 while(rs.next()) {
				 Address ad = new Address();
				 ad.setName(rs.getString("name"));
				 ad.setAddr(rs.getString("addr"));
				 ad.setZipcode(rs.getString("zipcode"));
				 ad.setTel(rs.getString("tel"));
				 ad.setNum(rs.getLong("num"));
				 arr.add(ad);
			 }	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;		 
	}
	
	
	//삭제
	public void addrDelete(int num) throws Exception {
		Connection con = null;
		Statement st = null;
		try {
			con=getConnection(); //deletePro와 연결 -> getConnection 필수!
			String sql = "delete from address where num="+num;
			st=con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st,null);
		}
	}
		
	//상세보기
	public Address addrDetail(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Address ad = null;
		
		try {
			con=getConnection();
			String sql="select* from address where num="+num;
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				ad=new Address();
				ad.setAddr(rs.getString("addr"));
				ad.setName(rs.getString("name"));
				ad.setNum(rs.getLong("num"));
				ad.setTel(rs.getString("tel"));
				ad.setZipcode(rs.getString("zipcode"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return ad;		
	}
	
	
	
	//우편번호 검색
	public ArrayList<ZipcodeBean> zipcodeRead(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipcodeBean> zipArr = new ArrayList<>();
				
		try {
			con=getConnection();
			// =           select * from zipcode where dong like'%서면%';
			String sql="select* from zipcode where dong like '%"+dong+"%'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				ZipcodeBean zip = new ZipcodeBean();
				zip.setBunji(rs.getString("bunji"));
				zip.setDong(rs.getString("dong"));
				zip.setGugun(rs.getString("gugun"));
				zip.setSeq(rs.getInt("seq"));
				zip.setSido(rs.getString("sido"));
				zip.setZipcode(rs.getString("zipcode"));
				zipArr.add(zip);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return zipArr;
	
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
