package com.reservation.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservation.model.AdminDTO;
import com.reservation.model.ReservationDAOImpl;
import com.reservation.model.ReservationDTO;
import com.reservation.model.RoomDTO;

@WebServlet("/reserve/respay")
public class ResPayAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ResPayAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		int rsno = Integer.parseInt(request.getParameter("rsno"));
		
		
		AdminDTO admin = dao.adminDetail(rsno);
		
		request.setAttribute("resArr", admin);
		RequestDispatcher rd = request.getRequestDispatcher("reservationPay.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
