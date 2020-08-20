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
		
		HashMap<String, String> map = new HashMap<>(); //selectList 인자 값에 두개가 들어가야 하니까 map으로 묶음
		map.put("field", field);
		map.put("word", word);
		
		
		SqlSessionFactory sqlMapper = MybatisManager.getSqlMapper();
		SqlSession sqlSession = sqlMapper.openSession(ExecutorType.REUSE);
		
		List<AddressVO> arr = sqlSession.selectList("searchData",map);
		
		int count = sqlSession.selectOne("countSearchData", map); //Hashmap이니까, integer안적어 줘도 됨.
		
		
		//JSON형태로 변환 위해 zipAction꺼 그대로 복붙
		HashMap<String,Object> hm = new HashMap<>(); // jsonarray = hashmap
		hm.put("arr", arr); 
		hm.put("count", count);
		
		//java > json
		Gson gson = new Gson(); 
		String obj = gson.toJson(hm); // gson > json 으로 처리
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
