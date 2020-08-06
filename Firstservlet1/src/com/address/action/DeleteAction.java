package com.address.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.model.SAddressDAO;

@WebServlet("/address/delete.do")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num"));
		
		SAddressDAO dao = new SAddressDAO();
		dao.addressDelete(num);
		
		response.sendRedirect("list.do"); //list.do를 부르면 list.jsp가 어차피 호출됨ㅋ		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
