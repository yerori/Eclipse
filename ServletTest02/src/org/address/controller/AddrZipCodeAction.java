package org.address.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.model.SAddressDAO;
import org.address.model.ZipcodeDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AddrZipCodeAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		 try {
			 String dong=((ServletRequest) resp).getParameter("dong");
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
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(mainObj.toString());
			
		 	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
}
