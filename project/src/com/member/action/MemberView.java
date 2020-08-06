package com.member.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.member.model.MemberDTO;
import com.member.model.SMemberDAOImpl;

@WebServlet("/member/view.me")
public class MemberView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberView() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		String userid = (String)se.getAttribute("userid"); 
		SMemberDAOImpl dao =SMemberDAOImpl.getInstance();
		MemberDTO dto = dao.memberView(userid);
		request.setAttribute("member", dto);
		RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
