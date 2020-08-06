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
		
		SAddressDTO sadd = new SAddressDTO(); //getter,setter���� class�̸��� new��ü�� ����
		sadd.setTel(tel);
		sadd.setName(name);
		sadd.setZipcode(zipcode);
		sadd.setAddr(addr);
		
		// addressŬ������ �� �ֱ�
		SAddressDAO dao = SAddressDAO.getInstance();
		dao.insertAddress(sadd);
		resp.sendRedirect("list.ad");
		
	}

}
