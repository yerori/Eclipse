package com.exam.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PersonAction
 */
@WebServlet("/exam/person2")
public class PersonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PersonAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		//PersonServlet 복붙 ㅋ
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
		rd.forward(req, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
