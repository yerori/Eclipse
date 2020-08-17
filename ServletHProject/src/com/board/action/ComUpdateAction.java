package com.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.model.BoardDAOImpl;
import com.board.model.ComDTO;

@WebServlet("/board/update")
public class ComUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ComUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("conDetail.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ComDTO com = new ComDTO();
		com.setCnum(Integer.parseInt(request.getParameter("cnum")));
		com.setContent(request.getParameter("content"));
		com.setEmail(request.getParameter("email"));
		com.setId(request.getParameter("id"));
		com.setSubject(request.getParameter("subject"));
		
		BoardDAOImpl dao = BoardDAOImpl.getInstance();
		dao.contentUpdate(com);
		response.sendRedirect("conEnd.jsp");

		}		
	}

