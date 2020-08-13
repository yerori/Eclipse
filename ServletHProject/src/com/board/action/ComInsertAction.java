package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.model.BoardDAOImpl;
import com.board.model.ComDTO;

@WebServlet("/board/coninsert")
public class ComInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ComInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
	
		HttpSession se = request.getSession();
		String id =(String)se.getAttribute("id");
		
		if(id==null) { //�α��� �ȵ� ��
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�α��� �ϼ���')"); //�񵿱� �Լ� �Ⱦ��µ�, �α��� �ȵ��� �� 
			out.println("location.href='../hotel/login.jsp'");
			out.println("</script>");
			
		}else { //�α��� ����~
			BoardDAOImpl board = BoardDAOImpl.getInstance();
		
			ComDTO dto = new ComDTO();
		
			dto.setContent(request.getParameter("content"));
			dto.setId(request.getParameter("id"));
			dto.setEmail(request.getParameter("email"));
			dto.setSubject(request.getParameter("subject"));
			int cnum = board.contactInsert(dto);
			response.sendRedirect("preview?cnum="+cnum);		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
