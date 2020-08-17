package com.admin.action;

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


@WebServlet("/admin/reslist")
public class AdResListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdResListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
			
		ArrayList<AdminDTO> arr = dao.adminList();
		int count = dao.resCount();
		
		request.setAttribute("adArr", arr);
		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("adResList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
