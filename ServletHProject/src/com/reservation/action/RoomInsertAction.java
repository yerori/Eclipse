package com.reservation.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.model.GuestDAOImpl;
import com.reservation.model.ReservationDAOImpl;
import com.reservation.model.RoomDTO;


@WebServlet("/admin/roominsert")
public class RoomInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RoomInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("adRoomInsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("utf-8");
		
		RoomDTO room = new RoomDTO();
		room.setRname(request.getParameter("rname"));
		room.setMen(Integer.parseInt(request.getParameter("men")));
		room.setBaby(Integer.parseInt(request.getParameter("baby")));
		room.setPrice(request.getParameter("price"));
		room.setRimage(request.getParameter("rimage"));

		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		dao.roomInsert(room);
		response.sendRedirect("roomlist");
		
	}

}
