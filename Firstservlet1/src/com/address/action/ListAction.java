package com.address.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.model.SAddressDAO;
import com.address.model.SAddressDTO;


@WebServlet("/address/list.do")
public class ListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SAddressDAO dao = SAddressDAO.getInstance();
		ArrayList<SAddressDTO> arr;
	
		int count=dao.addressCount();
		try {
			arr = dao.addrList();
			request.setAttribute("listArr", arr);
			request.setAttribute("count", count);
			
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
