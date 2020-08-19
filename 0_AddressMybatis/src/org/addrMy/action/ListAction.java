package org.addrMy.action;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/address_my/listAction.amy")
public class ListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SqlSessionFactory sqlMapper = MybatisManager.getSqlMapper();
		SqlSession sqlSession = sqlMapper.openSession(ExecutorType.REUSE);
		
		List<AddressVO> arr = sqlSession.selectList("listData");
		int count = (Integer)sqlSession.selectOne("countData"); //selectOne은 리턴형이 object
		request.setAttribute("arr", arr);
		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("addrList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
