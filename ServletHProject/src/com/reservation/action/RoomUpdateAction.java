package com.reservation.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservation.model.ReservationDAOImpl;
import com.reservation.model.RoomDTO;

@WebServlet("/admin/roomupdate")
public class RoomUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RoomUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("adRoomDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");		
		
		RoomDTO room = new RoomDTO();
		room.setTot_ad(Integer.parseInt(request.getParameter("tot_ad")));
		room.setTot_ch(Integer.parseInt(request.getParameter("tot_ch")));
		room.setRno(Integer.parseInt(request.getParameter("rno")));
		room.setPrice(request.getParameter("price"));
		room.setRimage(request.getParameter("rimage"));
		room.setRname(request.getParameter("rname"));
		
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		dao.roomUpdate(room);
		response.sendRedirect("roomlist");
		
		
	}

}
