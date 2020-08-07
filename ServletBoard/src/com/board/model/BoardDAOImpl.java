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


public class BoardDAOImpl implements BoardDAO{

	//db����
		private static BoardDAOImpl instance = new BoardDAOImpl();
		
		public static BoardDAOImpl getInstance() {
			return instance;
		}

		private Connection getConnection() throws Exception{
			Context iniCtx = new InitialContext();
			Context envCtx = (Context) iniCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/board");
			return ds.getConnection();
		}
	
	
	
	//�߰�
	@Override
	public void boardSave(BoardDTO board) {
		Connection con = null;
		PreparedStatement ps = null;	
		
		try {
			con=getConnection();				
			String sql ="insert into tbl_board values(tbl_board_seq.nextval,?,?,?,SYSDATE,0)";
			ps=con.prepareStatement(sql);
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getContent());
			ps.setString(3, board.getSubject());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
		
	}
	

	//����(update)
	@Override
	public void boardUpdate(BoardDTO board) {
		Connection con = null;
		PreparedStatement ps = null;	
		
		try {
			con=getConnection();				
			String sql ="update tbl_board set writer=?, content=?, subject=? where num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getContent());
			ps.setString(3, board.getSubject());
			ps.setInt(4, board.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
	}


	//��ü����
		public ArrayList<BoardDTO> boardList(String field, String word,int startRow, int endRow){
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<BoardDTO> arr = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			try {
				con = getConnection();
				if(word.equals("")) {
					sb.append("select * from");
					sb.append(" (select aa.*,rownum rn from");
					sb.append(" (select * from tbl_board order by num desc)aa");
					sb.append(" where rownum<=?) where rn >=?");
					
					
				}else {
					sb.append("select * from");
					sb.append(" (select aa.*,rownum rn from");
					sb.append(" (select * from tbl_board where "+field +" like '%"+word+"%'");
					sb.append(" order by num desc)aa");
					sb.append(" where rownum<=?) where rn >=?");	
				}
				ps = con.prepareStatement(sb.toString());
				ps.setInt(1, endRow);
				ps.setInt(2, startRow);
			
				rs = ps.executeQuery();
				while(rs.next()) {
					BoardDTO dto = new BoardDTO();
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setReg_date(rs.getString("reg_date"));
					dto.setReadcount(rs.getInt("readcount"));
					arr.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeConnection(con, ps, rs);
			}
			return arr;
		}
		
	//���̵�� �˻�
	@Override
	public BoardDTO boardfindById(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardDTO dto = null;
		
		try {
			con = getConnection();
			st = con.createStatement();
			
			String sql = "SELECT * FROM tbl_board WHERE num="+num;
			rs = st.executeQuery(sql);
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setReadcount(rs.getInt("readcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,st,rs);
		}
		
		return dto;
	}
	


	@Override
	public void boardDelete(int num) {
		// TODO Auto-generated method stub
		
	}
	
	//���� : �˻��� ��
	public int getCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		String sql="";
		try {
			con=getConnection();
			if(word.equals("")) { //�˻����ϸ�
				sql="select count(*) from tbl_board";
			}else { //�˻��� �ϸ�
				sql="select count(*) from tbl_board where "+field+" like '%"+word+"%'";
			} 
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//���� : �˻� ���� �ÿ�
	public int getCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
	
		try {
			con=getConnection();		
			String	sql="select count(*) from tbl_board";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
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

	@Override
	public ArrayList<BoardDTO> boardList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
