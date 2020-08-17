package com.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAOImpl;
import com.board.model.ComDTO;
import com.board.model.PageUtil;

@WebServlet("/board/list")
public class ComListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ComListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAOImpl dao = BoardDAOImpl.getInstance();
		String pageNum = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 5;
		int startRow=(currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;		
		int count=dao.contactCount();
		
		int totPage = (count/pageSize)+(count%pageSize==0?0:1);
		int pageBlock=3;
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage > totPage) endPage = totPage;
		
		PageUtil pu = new PageUtil();
		pu.setCurrentPage(currentPage);
		pu.setEndPage(endPage);
		pu.setPageBlock(pageBlock);
		pu.setStartPage(startPage);
		pu.setTotPage(totPage);
	
		
		
		ArrayList<ComDTO> arr = dao.contentList(startRow,endRow);
		
		int rowNo = count - ((currentPage-1)*pageSize);
		request.setAttribute("rowNo", rowNo);
		request.setAttribute("count", count);
		request.setAttribute("arr", arr);
		request.setAttribute("pu", pu);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("adContactList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
