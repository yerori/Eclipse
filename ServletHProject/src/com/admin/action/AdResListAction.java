package com.admin.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.PageUtil;
import com.reservation.model.AdminDTO;
import com.reservation.model.ReservationDAOImpl;
import com.reservation.model.ReservationDTO;
import com.reservation.model.RoomDTO;


@WebServlet("/admin/reslist")
public class AdResListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdResListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		String pageNum=request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		int currentPage = Integer.parseInt(pageNum);
		int pageSize=5;
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		int count=dao.resCount();
		
		int totPage = (count/pageSize)+(count%pageSize==0?0:1);
		int pageBlock=3;
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage>totPage) endPage = totPage ;
		
		PageUtil pu = new PageUtil();
		pu.setCurrentPage(currentPage);
		pu.setEndPage(endPage);
		pu.setPageBlock(pageBlock);
		pu.setStartPage(startPage);
		pu.setTotPage(totPage);
		
		ArrayList<AdminDTO> arr = dao.adminList(startRow,endRow);
		
		int rowNo = count - ((currentPage-1)*pageSize);
		
		request.setAttribute("rowNo", rowNo);
		request.setAttribute("pu", pu);
		request.setAttribute("adArr", arr);
		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("adResList.jsp");
		rd.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
