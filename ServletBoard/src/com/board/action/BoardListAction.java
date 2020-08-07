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
import com.board.model.BoardDTO;
import com.board.model.PageUtil;

@WebServlet("/board/list")
public class BoardListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BoardListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAOImpl dao = BoardDAOImpl.getInstance();
		
		String pageNum=request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		String field = request.getParameter("field")==null?"":request.getParameter("field");
		String word = request.getParameter("word")==null?"":request.getParameter("word");
		
		int currentPage=Integer.parseInt(pageNum);
		int pageSize=5;
		int startRow = (currentPage-1)*pageSize+1;
		int endRow=currentPage*pageSize;
		
		
		int count=dao.getCount(field, word);
		int totPage=(count/pageSize)+(count%pageSize==0?0:1);
		int pageBlock =3;
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		
		
		if(endPage>totPage) endPage=totPage; //전체 페이지가 end페이지가 되라!
		
		PageUtil pu = new PageUtil();
		pu.setCurrentPage(currentPage);
		pu.setEndPage(endPage);
		pu.setField(field);
		pu.setPageBlock(pageBlock);
		pu.setStartPage(startPage);
		pu.setTotPage(totPage);
		pu.setWord(word);
				
		ArrayList<BoardDTO> arr = null;
		arr=dao.boardList(field,word,startRow, endRow);
		
		
		request.setAttribute("pu", pu);
		request.setAttribute("arr", arr);
		request.setAttribute("count", count);
		
		RequestDispatcher rd = request.getRequestDispatcher("listResult.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}