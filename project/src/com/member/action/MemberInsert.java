package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDTO;
import com.member.model.SMemberDAOImpl;

@WebServlet("/member/insert.me")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MemberInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SMemberDAOImpl dao = SMemberDAOImpl.getInstance();
		MemberDTO member = new MemberDTO();
		member.setAdmin(Integer.parseInt(request.getParameter("admin")));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setName(request.getParameter("name"));
		member.setPwd(request.getParameter("pwd"));
		member.setUserid(request.getParameter("userid"));
		dao.memberInsert(member);
		response.sendRedirect("login.me");
		
		
	}

}
