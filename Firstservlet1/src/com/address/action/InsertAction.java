package com.address.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.model.SAddressDAO;
import com.address.model.SAddressDTO;


@WebServlet("/address/insert.do")
public class InsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public InsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String zipcode=request.getParameter("zipcode");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		SAddressDTO sadd = new SAddressDTO(); //getter,setter만든 class이름을 new객체로 생성
		sadd.setTel(tel);
		sadd.setName(name);
		sadd.setZipcode(zipcode);
		sadd.setAddr(addr);
		
		// address클래스에 값 넣긔
		SAddressDAO dao = SAddressDAO.getInstance();
		dao.insertAddress(sadd);
		response.sendRedirect("list.do");
	}
}
