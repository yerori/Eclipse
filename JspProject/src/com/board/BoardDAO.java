package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BoardDAO {
	
	//DB세팅
	private static BoardDAO instance = new BoardDAO();
	
	
	public static BoardDAO getInstance() {
		return instance;
		}

	private Connection getConnection() throws Exception{
		Context iniCtx = new InitialContext();
		Context envCtx = (Context) iniCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/member"); //context.xml의 user 변경 (board라고 해서 member바꿈x)
		return ds.getConnection();
		}
	
	// DML에만 PreparedStatement!!
	
	
	//추가
	public void boardInsert(BoardVO board) { //새글 답글 구분
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		
		//부모글
		int num=board.getNum();
		int ref=board.getRef();
		int re_step=board.getRe_step();
		int re_level=board.getRe_level();
		
		int number=0;
		String sql="";
		
		try {
			con=getConnection();
			ps=con.prepareStatement("select max(num) from board");
			rs=ps.executeQuery();
			if(rs.next()) { //기존데이터가 있을 때 ref를 최대값+1로 결정
				number=rs.getInt(1)+1;
			}else {//기존data가 없을 때 : ref를 1로 결정
				number=1;
			}
			if(num!=0) { //답글
				sql="update board set re_step = re_step+1 where ref=? and re_step>?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, ref);
				ps.setInt(2, re_step);
				ps.executeUpdate();
				re_step=re_step+1;
				re_level=re_level+1;
			}else { //새글
				ref=number;
				re_step = 0;
				re_level = 0;
			}
						
			sql="insert into board(num,writer,subject,email,content,ip,readcount,ref,re_step,re_level,passwd) "
					+ "values(board_seq.nextval,?,?,?,?,?,0,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getSubject());
			ps.setString(3, board.getEmail());
			ps.setString(4, board.getContent());
			ps.setString(5, board.getIp());
			ps.setInt(6, ref);
			ps.setInt(7, re_step);
			ps.setInt(8, re_level);
			ps.setString(9, board.getPasswd());
			ps.executeUpdate();		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}		
	}
	

	
	
	
	//수정	
	public int boardUpdate(BoardVO board) {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int flag=0;
		String sql="";
		
		try {
			con=getConnection();
		// 비밀번호가 같을 시에만 수정완료되게	
			sql="select passwd from board where num="+board.getNum();
			ps=con.prepareStatement(sql); // passwd추출
			rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("passwd").equals(board.getPasswd())) {
					sql="Update board set subject=?, email=?, content=?, reg_date=sysdate where num=?";
						
					ps.setString(1, board.getSubject());
					ps.setString(2, board.getEmail());
					ps.setString(3, board.getContent());		
					ps.setInt(4, board.getNum());	
					flag = ps.executeUpdate(); // 업뎃된 수를 flag에 담음 ,,
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

	
	//상세보기
	public BoardVO boardView(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardVO board=null;
		
		try {
			con=getConnection();
			st=con.createStatement();
			st.executeUpdate("update board set readcount=readcount+1 where num="+num);
			String sql="select * from board where num="+num;

			rs=st.executeQuery(sql);
			if(rs.next()) {
				board=new BoardVO();
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRef(rs.getInt("ref"));
				board.setRe_step(rs.getInt("re_step"));
				board.setRe_level(rs.getInt("re_level"));
				board.setPasswd(rs.getString("passwd"));
				board.setReg_date(rs.getString("reg_date"));				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return board;
	}
	
	
	
	//전체보기 -검색아님
	public ArrayList<BoardVO> boardList(int startRow, int endRow){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<BoardVO> arr = new ArrayList<>();
		
		try {
			con=getConnection();
			String sql = "select * from(select rownum rn,aa.* from(select * from board order by ref desc, re_step asc)aa) "
					+ "where rn<=? and rn>=?";								// 괄호안의 as(별칭)이 aa다
																	
			ps=con.prepareStatement(sql);
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO board=new BoardVO();
				board.setNum(rs.getInt("num"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setReg_date(rs.getString("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setIp(rs.getString("ip"));
				arr.add(board);							
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,ps,rs);
		}			
		return arr;
	}
	
	
	//전체보기-검색
	public ArrayList<BoardVO> boardList(String field,String word, int startRow, int endRow){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<BoardVO> arr = new ArrayList<>();
		
		try {
			con=getConnection();
			String sql = "select * from(select rownum rn,aa.* from(select * from board where "
					+ field +" like'%"+word+"%' order by ref desc, re_step asc)aa) "
					+ "where rn<=? and rn>=?";	
			ps=con.prepareStatement(sql);
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO board=new BoardVO();
				board.setNum(rs.getInt("num"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setReg_date(rs.getString("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setIp(rs.getString("ip"));
				arr.add(board);							
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,ps,rs);
		}			
		return arr;
	}
		
	//삭제
	public int boardDelete(int num) {
		Connection con=null;
		Statement st =null;
	
		int flag=0;
		
		try {
			con=getConnection();
			String sql="delete from board where num="+num;
			st=con.prepareStatement(sql);
			flag = st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, null);
		}		
		return flag;
	}
	
	//count개수 : 검색없음
		public int boardCount() {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			int count=0;
			
			try {
				con=getConnection();
				String sql = "select count(*) from board";
				st=con.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next()) {
					count=rs.getInt(1);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection(con, st,rs);
			}
			return count; 
		}
			

	
	//count개수 :검색
	public int boardCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=getConnection();
			String sql = "select count(*) from board where "+field+" like '%"+word+"%'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st,rs);
		}
		return count; 
	}
	
	
	//코멘트 추가
	public void commentInsert(CommentVO cvo) {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=getConnection();
			String sql="insert into commentboard(cnum,userid,regdate,msg,bnum) values(comment_seq.nextval,?,sysdate,?,?)";
			ps=con.prepareStatement(sql);		
			ps.setString(1, cvo.getUserid());
			ps.setString(2,cvo.getMsg());
			ps.setInt(3, cvo.getBnum());
			rs=ps.executeQuery();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
		
	}

	
	// 코멘트보기
	public ArrayList<CommentVO> commentList(int num) {
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<CommentVO> arr = new ArrayList<>();
		
		try {
			con=getConnection();
			String sql = "select * from commentboard where bnum= "+num+" order by cnum desc";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next()) {
				CommentVO cmt = new CommentVO();
				cmt.setCnum(rs.getInt("cnum"));
				cmt.setUserid(rs.getString("userid"));
				cmt.setRegdate(rs.getString("regdate"));
				cmt.setMsg(rs.getString("msg"));
				cmt.setBnum(rs.getInt("bnum"));
				arr.add(cmt);	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st,rs);
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
