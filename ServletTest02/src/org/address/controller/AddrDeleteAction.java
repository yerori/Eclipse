package org.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.model.SAddressDAO;

public class AddrDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int num=Integer.parseInt(req.getParameter("num"));
		
		SAddressDAO dao = new SAddressDAO();
		dao.addressDelete(num);
		
		resp.sendRedirect("list.ad");
	}

}
