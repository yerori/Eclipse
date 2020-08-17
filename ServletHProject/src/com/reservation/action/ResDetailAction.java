package com.reservation.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reservation.model.ReservationDAOImpl;
import com.reservation.model.ReservationDTO;

@WebServlet("/reserve/resdetail")
public class ResDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ResDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		int rsno = Integer.parseInt(request.getParameter("rsno"));
		
		ReservationDTO arr= dao.resDetail(rsno);
		
		
		request.setAttribute("resArr", arr);
		
		RequestDispatcher rd = request.getRequestDispatcher("reservationDetail.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
