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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.guest.model.GuestDAOImpl;
import com.guest.model.ZipcodeDTO;

@WebServlet("/hotel/zipcode")
public class GuestZipcodeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public GuestZipcodeAction() {
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("zipCheck.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dong=request.getParameter("dong");
		GuestDAOImpl dao = GuestDAOImpl.getInstance();
		ArrayList<ZipcodeDTO> arr = dao.zipSearch(dong);
		
		JSONObject mainObj = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(ZipcodeDTO zip : arr ) {
			JSONObject obj = new JSONObject();
			obj.put("zipcode", zip.getZipcode());
			obj.put("sido", zip.getSido());
			obj.put("gugun", zip.getGugun());
			obj.put("dong", zip.getDong());
			obj.put("bunji", zip.getBunji());
			jarr.add(obj);
		}
		mainObj.put("jarr",jarr);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(mainObj.toString());		
	}

}
