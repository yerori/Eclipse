package org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action { // doget, dopost�� ���� execute�Լ� ���� 
							//	-> get,post���� ���� �𸣱� ������ 
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException;
}
