package com.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAOImpl;
import com.board.model.BoardDTO;

@WebServlet("/board/insert")
public class BoardInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAOImpl dao = BoardDAOImpl.getInstance();
		BoardDTO board = new BoardDTO();
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		board.setSubject(request.getParameter("subject"));
//		board.setReg_date(request.getParameter("reg_date"));
//		board.setReadcount(Integer.parseInt(request.getParameter("readcount")));
//		
		dao.boardSave(board);
		response.sendRedirect("list.jsp");
	}

}
