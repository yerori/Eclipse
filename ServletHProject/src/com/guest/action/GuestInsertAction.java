package com.guest.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.model.GuestDAO;
import com.guest.model.GuestDAOImpl;
import com.guest.model.GuestDTO;

@WebServlet("/hotel/insert")
public class GuestInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GuestInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		GuestDTO guest =new GuestDTO();
		guest.setAddress(request.getParameter("address"));
		guest.setEmail(request.getParameter("email"));
		guest.setId(request.getParameter("id"));
		guest.setPhone(request.getParameter("phone"));
		guest.setPwd(request.getParameter("pwd"));
		
		GuestDAO dao = GuestDAOImpl.getInstance();
		dao.guestInsert(guest);
		response.sendRedirect("login");
		
	}

}
