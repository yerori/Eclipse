package org.addrMy.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.addrMy.config.MybatisManager;
import org.addrMy.model.AddressVO;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/address_my/insertAction.amy")
public class InsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public InsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addrInsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AddressVO avo = new AddressVO();
		avo.setAddr(request.getParameter("addr"));
		avo.setName(request.getParameter("name"));
		avo.setTel(request.getParameter("tel"));
		avo.setZipcode(request.getParameter("zipcode"));
		
		SqlSessionFactory sqlMapper = MybatisManager.getSqlMapper();
		SqlSession sqlSession = sqlMapper.openSession(ExecutorType.REUSE);
		
		sqlSession.insert("insertData",avo); //avo는 parameterType(="org.addrMy.model.AddressVO")과 같아야 함
		sqlSession.commit(); //dao에서는 commit이 자동
		
		response.sendRedirect("listAction.amy");
		
		
	}
}
