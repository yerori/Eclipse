package org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action { // doget, dopost를 닮은 execute함수 만듦 
							//	-> get,post어디로 갈지 모르기 때문에 
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException;
}
