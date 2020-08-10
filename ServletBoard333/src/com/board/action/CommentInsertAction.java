package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.board.model.BoardDAO;
import com.board.model.BoardDAOImpl;
import com.board.model.CommentDTO;

@WebServlet("/board/commentInsert")
public class CommentInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommentInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String msg=request.getParameter("msg");
		int bnum = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		String userid=(String)session.getAttribute("userid");
//		if(userid==null) { //�α��� �ȵ�
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("1");
//		}else {//�α��� ��
			CommentDTO comment = new CommentDTO();
			comment.setBnum(bnum);
			comment.setMsg(msg);
			comment.setUserid("userid"); //�޾ƿ� ���ǰ� �ִµ�, ���� ������ ""
			BoardDAOImpl dao = BoardDAOImpl.getInstance();
			dao.commentInsert(comment);
			
		// comment list ArrayList�� ��� json���� ����
		// ���� commentListAction ���� ���� �ʰ�, �̷��� ȣ���ϸ� ��
			response.sendRedirect("commentlist?num="+bnum);
				
		}
	//}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
