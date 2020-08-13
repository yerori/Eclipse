package com.reservation.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservation.model.ReservationDAOImpl;

@WebServlet("/admin/roomdelete")
public class RoomDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RoomDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		dao.roomDelete(rno);
		
		response.sendRedirect("roomlist");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
