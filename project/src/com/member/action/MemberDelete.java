package com.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.SMemberDAOImpl;

@WebServlet("/member/delete.me")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MemberDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(); //session : hashmap에 넣는 것처럼
		String userid=(String)se.getAttribute("userid");
		SMemberDAOImpl dao = SMemberDAOImpl.getInstance();
		dao.memberDel(userid); //반환값이 없으니까 int, string에 담지 x
		se.invalidate(); //★세션삭제
		response.sendRedirect("login.me");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
