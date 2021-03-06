package com.guest.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guest.model.GuestDAO;

@WebServlet("/guestbook/login.gb")
public class GuestLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GuestLoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		GuestDAO dao = GuestDAO.getInstance();
		String path="";
		int flag = dao.guestLoginCheck(userid, pwd); //멤버 테이블 사용
		
		if(flag==1) { //회원 O
			HttpSession session = request.getSession(); //로그인 정보 저장 위해 세션 사용
			session.setAttribute("login", userid);
			path="insert.jsp";
		}else if(flag==0) { //비번 오류
			request.setAttribute("errMsg", "비밀번호 오류");
			path="login.jsp";
		}else if(flag==-1){ //회원 X
			request.setAttribute("errMsg", "회원이 아닙니다.");
			path="login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
