package com.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberDTO;
import com.member.model.SMemberDAOImpl;


@WebServlet("/member/update.me")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=0;
		request.setCharacterEncoding("utf-8");
		MemberDTO dto = new MemberDTO();
		dto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		dto.setEmail(request.getParameter("email"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setUserid(request.getParameter("userid"));
		
		SMemberDAOImpl dao = SMemberDAOImpl.getInstance();
		flag=dao.memberUpdate(dto);
		if(flag==1) {
		HttpSession se = request.getSession();
		se.invalidate();
		response.sendRedirect("login.me");
		}
	}

}
