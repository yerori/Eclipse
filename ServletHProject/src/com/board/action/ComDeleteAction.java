package com.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAOImpl;


@WebServlet("/board/delete")
public class ComDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ComDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int cnum=Integer.parseInt(request.getParameter("cnum"));
		BoardDAOImpl dao = BoardDAOImpl.getInstance();
		dao.contactDelete(cnum);
		
		response.sendRedirect("contact.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
