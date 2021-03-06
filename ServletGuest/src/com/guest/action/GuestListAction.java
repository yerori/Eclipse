package com.guest.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.model.GuestDAO;
import com.guest.model.GuestDTO;
import com.guest.model.PageUtil;


@WebServlet("/guestbook/list.gb")
public class GuestListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GuestListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		GuestDAO dao = GuestDAO.getInstance();
		
		String pageNum=request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		String field=request.getParameter("field")==null?"":request.getParameter("field");
		String word=request.getParameter("word")==null?"":request.getParameter("word");
		
		int currentPage=Integer.parseInt(pageNum);
		int pageSize = 5; //한 페이지에 5번까지
		int startRow = (currentPage-1)*pageSize+1;
		int endRow=currentPage*pageSize;
	
		try {
			
			int count=dao.getCount(field,word);
			//총페이지수
			int totPage=(count/pageSize)+(count%pageSize==0?0:1);
			int pageBlock = 3; //1,2,3 숫자 페이지만
			int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
			int endPage = startPage+pageBlock-1;
			
			if(endPage>totPage) endPage=totPage; //마지막 숫자는 나오면 x
			
			PageUtil pu = new PageUtil();
			pu.setCurrentPage(currentPage);
			pu.setEndPage(endPage);
			pu.setPageBlock(pageBlock);
			pu.setStartPage(startPage);
			pu.setTotPage(totPage);
			pu.setField(field);
			pu.setWord(word);
			
			ArrayList<GuestDTO> arr =null;
			
			if(word.equals("")) { //검색할 값이 없으면 
				arr=dao.guestList(startRow,endRow);
			}else {
				arr=dao.guestList(field,word,startRow,endRow);
			}
			
			int rowNo = count-((currentPage-1)*pageSize); //매 페이지의 시작번호

			request.setAttribute("rowNo", rowNo);
			request.setAttribute("pu", pu);			
			request.setAttribute("guestbook", arr);
			request.setAttribute("count", count);
			RequestDispatcher rd = request.getRequestDispatcher("listResult.jsp");
			rd.forward(request, response);
		} catch (Exception e) {		
			e.printStackTrace();
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
