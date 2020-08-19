package com.guest.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guest.model.GuestDAOImpl;
import com.guest.model.GuestDTO;

/**
 * Servlet implementation class GuestLoginAction
 */
@WebServlet("/hotel/login")
public class GuestLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestLoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		GuestDAOImpl dao=GuestDAOImpl.getInstance();
		
//		int flag=dao.guestLoginChk(id, pwd);
//		if(flag==0 || flag==1) { // 일반회원이거나 관리자
//			HttpSession se = request.getSession();
//			se.setAttribute("id", id);			
//		}
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println(flag);
//		response.sendRedirect("hiltonindex.jsp");
		
		GuestDTO guest=dao.guestLoginChk(id, pwd);
		HttpSession se = request.getSession();
		System.out.println("admin"+guest.getAdmin());
		if(guest.getAdmin()==0 ||guest.getAdmin()==1) {
			se.setAttribute("id", guest.getId());
			se.setAttribute("gno", guest.getGno());
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(guest.getAdmin());
		
		
	}

}
