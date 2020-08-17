package com.admin.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservation.model.ReservationDAOImpl;


@WebServlet("/admin/resdelete")
public class AdResDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdResDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int rsno = Integer.parseInt(request.getParameter("rsno"));
		
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		dao.adminDelete(rsno);
		
		response.sendRedirect("reslist");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
