package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.board.model.BoardDAOImpl;
import com.board.model.ComDTO;


@WebServlet("/admin/condelete")
public class AdContactDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdContactDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int cnum = Integer.parseInt(request.getParameter("cnum")); //cnum이 유일한 값이니까
		BoardDAOImpl dao=BoardDAOImpl.getInstance();
		
		dao.contactDelete(cnum);
		
		response.sendRedirect("conlist");
		
//		int startRow=Integer.parseInt(request.getParameter("startRow"));
//		int endRow=Integer.parseInt(request.getParameter("endRow"));
//		ArrayList<ComDTO> arr= dao.contentList(startRow,endRow); //이거 안되면 그냥 contentList도 하나 만드기
//		int count = dao.contactCount();
//		JSONObject mainObj = new JSONObject();
//		JSONArray jarr = new JSONArray();
//		for(ComDTO dto : arr) {
//			JSONObject obj = new JSONObject();
//			obj.put("cnum", dto.getCnum());
//			obj.put("content", dto.getContent());
//			obj.put("id", dto.getId());
//			obj.put("email", dto.getEmail());
//			obj.put("subject", dto.getSubject());
//			jarr.add(obj);
//		}
//		JSONObject countObj = new JSONObject();
//		countObj.put("count", count);
//		
//		mainObj.put("root", jarr);
//		mainObj.put("rootCount", countObj);
//		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println(mainObj.toString());
		
//		
//		request.setAttribute("con", content);
//		RequestDispatcher rd = request.getRequestDispatcher("adContactList.jsp");
//		rd.forward(request, response);	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
