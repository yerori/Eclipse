package com.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAOImpl;
import com.board.model.BoardDTO;

@WebServlet("/board/update")
public class BoardUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDTO board = new BoardDTO();
		board.setNum(Integer.parseInt(request.getParameter("num")));
		board.setContent(request.getParameter("content"));
		board.setReadcount(Integer.parseInt(request.getParameter("readcount")));
		board.setReg_date(request.getParameter("reg_date"));
		board.setSubject(request.getParameter("subject"));
		
		

		BoardDAOImpl dao = BoardDAOImpl.getInstance();
		dao.boardUpdate(board);
		response.sendRedirect("list.jsp");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
