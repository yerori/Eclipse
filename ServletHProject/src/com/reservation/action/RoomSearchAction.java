package com.reservation.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.reservation.model.ReservationDAOImpl;
import com.reservation.model.RoomDTO;

@WebServlet("/hotel/roomsearch")
public class RoomSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoomSearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		ArrayList<RoomDTO> arr = dao.roomList();	
		
		request.setAttribute("roomArr", arr);
		
		//GuestDAOImpl dao1 = GuestDAOImpl.getInstance();
		//ArrayList<GuestDTO> arr1 = dao1.guestList();
		
		//request.setAttribute("guestArr", arr1);
		
		RequestDispatcher rd = request.getRequestDispatcher("../reserve/reservation.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
