package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.board.model.BoardDAOImpl;
import com.board.model.CommentDTO;

@WebServlet("/board/commentlist")
public class CommentListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CommentListAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bnum=Integer.parseInt(request.getParameter("num")); //getJSON���� num�̶� �̸����� ������
		BoardDAOImpl dao = BoardDAOImpl.getInstance();
		ArrayList<CommentDTO> arr= dao.commentList(bnum);
		
		//arr�� json���·� �ٲ㼭 ����~!
		JSONObject mainobj = new JSONObject();
		JSONArray jarr = new JSONArray();
		for(CommentDTO c : arr) {
			JSONObject obj = new JSONObject();
			obj.put("cnum", c.getCnum());
			obj.put("bnum", c.getBnum());
			obj.put("msg", c.getMsg());
			obj.put("regdate", c.getRegdate());
			obj.put("userid", c.getUserid());
			jarr.add(obj);
		}
		mainobj.put("carr",jarr);

		//ȭ�鿡 ��� ���� �ڵ�,,
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(mainobj.toString()); //main�� carr����� ��ǥ
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
