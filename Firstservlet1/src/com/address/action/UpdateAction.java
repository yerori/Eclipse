package com.address.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.model.SAddressDAO;
import com.address.model.SAddressDTO;


@WebServlet("/address/update.do")
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SAddressDTO sadd = new SAddressDTO(); 
		sadd.setNum(Integer.parseInt(request.getParameter("num")));
		sadd.setTel(request.getParameter("tel"));
		sadd.setName(request.getParameter("name"));
		sadd.setZipcode(request.getParameter("zipcode"));
		sadd.setAddr(request.getParameter("addr"));
		
		SAddressDAO dao = SAddressDAO.getInstance();
		dao.addressUpdate(sadd);
		response.sendRedirect("list.do");
	}
                                                                                                                                                                 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
