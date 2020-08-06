package org.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.model.SAddressDAO;
import org.address.model.SAddressDTO;

public class AddrUpdateAction implements Action {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SAddressDTO sadd = new SAddressDTO(); 
		sadd.setNum(Integer.parseInt(req.getParameter("num")));
		sadd.setTel(req.getParameter("tel"));
		sadd.setName(req.getParameter("name"));
		sadd.setZipcode(req.getParameter("zipcode"));
		sadd.setAddr(req.getParameter("addr"));
		
		SAddressDAO dao = SAddressDAO.getInstance();
		dao.addressUpdate(sadd);
		resp.sendRedirect("list.ad");
	}
}
