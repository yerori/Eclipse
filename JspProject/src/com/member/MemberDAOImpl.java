package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.management.MBeanAttributeInfo;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

	//db����
public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl instance = new MemberDAOImpl();
	
	public static MemberDAOImpl getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception{
		Context iniCtx = new InitialContext();
		Context envCtx = (Context) iniCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/member"); //context.xml�� user ����
		return ds.getConnection();
	}

	//DML,DDL : executeUpdate() ���
	//��ȸ (SELECT, VIEW) : executeQuery() ���
	
	//�߰�
	@Override
	public void memberInsert(MemberVO vo) {
		Connection con=null;
		PreparedStatement ps = null;
				
		try {
			con=getConnection();
			String sql = "insert into member values(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getUserid());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getPwd());
			ps.setString(4, vo.getEmail());
			ps.setInt(5, vo.getAdmin());
			ps.setString(6, vo.getPhone());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}				
	}
	
	
	//����
	@Override
	public int memberUpdate(MemberVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		int flag=0;
			
		try {
			con=getConnection();
			String sql = "update member set name=?, email=?, admin=?, phone=? where userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getEmail());
			ps.setInt(3, vo.getAdmin());
			ps.setString(4, vo.getPhone());
			ps.setString(5, vo.getUserid());
			flag = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}	
		return flag;
	}

	
	
	//��ü����
	@Override
	public ArrayList<MemberVO> memberList() {
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<MemberVO> arr = new ArrayList<MemberVO>();
		String sql="";
		
		try {
			con=getConnection();
			sql = "select * from member";
			st=con.createStatement();
			rs=st.executeQuery(sql);			
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setName(rs.getString("name"));
				member.setUserid(rs.getString("userid"));
				member.setPhone(rs.getString("phone"));
				member.setAdmin(rs.getInt("admin"));
				member.setEmail(rs.getString("email"));
				member.setPwd(rs.getString("pwd"));
				arr.add(member);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs); 
		}
		return arr;
	}

	
	// �󼼺���
	@Override
	public MemberVO memberView(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		MemberVO member=null;
		
		try {
			con=getConnection();
			String sql = "select* from member where userid='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				member=new MemberVO();
				member.setAdmin(rs.getInt("admin"));
				member.setName(rs.getString("name"));
				member.setUserid(rs.getString("userid"));
				member.setPwd(rs.getString("pwd"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs); 
		}			
		return member;
	}

	
	//����
	@Override
	public void memberDel(String userid) {
		Connection con=null;
		Statement st = null;
		
		try {
			con=getConnection();
			String sql = "delete from member where userid='"+userid+"'";
						//delete from member where userid='userid';
			st=con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st,null);
		}	
	}
	
	
	//list member ����	
	public int memberCount() {
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=getConnection();
			st=con.createStatement();
			String sql="select count(*) from member";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return count;
	}
	

	@Override
	public String idCheck(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String flag="yes";
		
		try {
			con=getConnection();
			String sql="select* from member where userid='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				flag = "no"; //���Ұ�
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return flag;
	}
	
	
	public int loginCheck(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int flag=-1; //-1�� �� ȸ���� �ƴ� 
		
		try {
			con=getConnection();
			String sql="select* from member where userid='"+userid+"'";
			//"select* from member where userid='userid'"
	
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) { // id�� ���� 
				if(rs.getString("pwd").equals(pwd)) { //��� ���� 
									// ���� �޾ƿ� �� : equals(pwd)
					flag = rs.getInt("admin"); 
						
				}else { //��� Ʋ��
					flag=2;				
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return flag;
		
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
