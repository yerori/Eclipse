package org.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.model.SAddressDAO;
import org.address.model.SAddressDTO;



public class AddrInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String zipcode=req.getParameter("zipcode");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		
		SAddressDTO sadd = new SAddressDTO(); //getter,setter만든 class이름을 new객체로 생성
		sadd.setTel(tel);
		sadd.setName(name);
		sadd.setZipcode(zipcode);
		sadd.setAddr(addr);
		
		// address클래스에 값 넣긔
		SAddressDAO dao = SAddressDAO.getInstance();
		dao.insertAddress(sadd);
		resp.sendRedirect("list.ad");
		
	}

}
