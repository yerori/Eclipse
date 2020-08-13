package com.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAOImpl;
import com.board.model.ComDTO;

@WebServlet("/admin/condetail")
public class AdContactDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AdContactDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int cnum=Integer.parseInt(request.getParameter("cnum"));
		BoardDAOImpl dao=BoardDAOImpl.getInstance();
		ComDTO content = dao.contactDetail(cnum);
		
		request.setAttribute("con", content);
		RequestDispatcher rd = request.getRequestDispatcher("adContactDetail.jsp");
		rd.forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
