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
		HttpSession se = request.getSession(); //session : hashmap�� �ִ� ��ó��
		String userid=(String)se.getAttribute("userid");
		SMemberDAOImpl dao = SMemberDAOImpl.getInstance();
		dao.memberDel(userid); //��ȯ���� �����ϱ� int, string�� ���� x
		se.invalidate(); //�ڼ��ǻ���
		response.sendRedirect("login.me");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
