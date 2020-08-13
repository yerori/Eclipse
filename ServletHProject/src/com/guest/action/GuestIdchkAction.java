package com.guest.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.model.GuestDAOImpl;


@WebServlet("/hotel/idcheck")
public class GuestIdchkAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public GuestIdchkAction() {
        super();
        // TODO Auto-generated constructor stub
    } 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("idCheck.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		GuestDAOImpl dao = GuestDAOImpl.getInstance();
		String flag=dao.idCheck(id);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(flag);
		
	}

}
