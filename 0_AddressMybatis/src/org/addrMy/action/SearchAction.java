package org.addrMy.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

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

import com.google.gson.Gson;

@WebServlet("/address_my/searchAction.amy")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String word = request.getParameter("word");
		String field = request.getParameter("field");
		
		HashMap<String, String> map = new HashMap<>(); //selectList ���� ���� �ΰ��� ���� �ϴϱ� map���� ����
		map.put("field", field);
		map.put("word", word);
		
		
		SqlSessionFactory sqlMapper = MybatisManager.getSqlMapper();
		SqlSession sqlSession = sqlMapper.openSession(ExecutorType.REUSE);
		
		List<AddressVO> arr = sqlSession.selectList("searchData",map);
		
		int count = sqlSession.selectOne("countSearchData", map); //Hashmap�̴ϱ�, integer������ �൵ ��.
		
		
		//JSON���·� ��ȯ ���� zipAction�� �״�� ����
		HashMap<String,Object> hm = new HashMap<>(); // jsonarray = hashmap
		hm.put("arr", arr); 
		hm.put("count", count);
		
		//java > json
		Gson gson = new Gson(); 
		String obj = gson.toJson(hm); // gson > json ���� ó��
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
