package com.exam.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PersonServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String gender = req.getParameter("gender");
		String[] notice= req.getParameterValues("notice"); //checkbox: 중복 가능 -> 배열에 담긔
		String job = req.getParameter("job");
		Person person = new Person();
		person.setGender(gender);
		person.setId(id);
		person.setJob(job);
		person.setNotice(notice);
		person.setName(name);
		
		req.setAttribute("p", person);
		req.setAttribute("msg", "@WebServlet사용");
		RequestDispatcher rd = req.getRequestDispatcher("personResult2.jsp");
		rd.forward(req, resp);

	}
}