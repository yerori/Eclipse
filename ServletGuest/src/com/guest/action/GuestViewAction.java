package com.guest.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.guest.model.GuestDAO;
import com.guest.model.GuestDTO;


@WebServlet("/guestbook/view.gb")
public class GuestViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GuestViewAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(request.getParameter("num"));
		
		GuestDAO dao = GuestDAO.getInstance();
		GuestDTO dto = dao.guestView(num);
		
		//자바 Object -> JSON형태로 ,,
		// fview함수를 JSON형태로 호출했으니
		JSONObject obj = new JSONObject();
		obj.put("name", dto.getName());//put (jsp에서 출력할 값 , 변수)
		obj.put("content", dto.getContent()); //set이 put같은 역할                         .
		obj.put("grade", dto.getGrade());
		obj.put("ipaddr", dto.getIpaddr());
		obj.put("num", dto.getNum());
		obj.put("created", dto.getCreated());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj.toString());	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
