package com.address.action;

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

import com.address.model.SAddressDAO;
import com.address.model.ZipcodeDTO;

@WebServlet("/address/zip.do")
public class ZipAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ZipAction() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("zipCheck.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("zipCheck.jsp"); 
		rd.forward(request, response); // 주소창에zip.do가 계속 지속됨
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	
		 try {
			 String dong=request.getParameter("dong");
			 SAddressDAO dao = SAddressDAO.getInstance();
			ArrayList<ZipcodeDTO> arr =  dao.zipSearch(dong);
			
			JSONObject mainObj=new JSONObject(); // mainObj : 개수
			JSONArray jarr = new JSONArray();
			for(ZipcodeDTO zip : arr) {
			 JSONObject obj=new JSONObject();
			 obj.put("zipcode", zip.getZipcode());
			 obj.put("sido", zip.getSido());
			 obj.put("gugun", zip.getGugun());
			 obj.put("dong", zip.getDong());
			 obj.put("bunji", zip.getBunji());
			 jarr.add(obj);			 
			}
			mainObj.put("jarr", jarr);
			
			//출력하기위해~~
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			
			out.println(mainObj.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
