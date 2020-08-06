package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsServlet implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>���</title></head>");
		out.println("<body>");
		out.println("�̸� : "+name+"<br>"); 
		out.println("���� : "+title+"<br>");
		out.println("���� : "+content);
		out.println("</body>");
		out.println("</html>");
			
	  }
	}

