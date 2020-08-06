package com.member.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDTO;
import com.member.model.SMemberDAOImpl;


@WebServlet("/member/list.me")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		SMemberDAOImpl dao = SMemberDAOImpl.getInstance();
		int count=dao.getCount();
		ArrayList<MemberDTO> arr = dao.memberList();
		request.setAttribute("members", arr);
		request.setAttribute("count", count);
		
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
