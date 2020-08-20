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

@WebServlet("/address_my/updateAction.amy")
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addrView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		AddressVO avo = new AddressVO();
		
		avo.setAddr(request.getParameter("addr"));
		avo.setName(request.getParameter("name"));
		avo.setNum(Integer.parseInt(request.getParameter("num")));
		avo.setTel(request.getParameter("tel"));
		avo.setZipcode(request.getParameter("zipcode"));
		
		SqlSessionFactory sqlMapper = MybatisManager.getSqlMapper();
		SqlSession sqlSession = sqlMapper.openSession(ExecutorType.REUSE);
		
		sqlSession.update("updateData",avo);
		sqlSession.commit();
		
		response.sendRedirect("listAction.amy");
	}

}
