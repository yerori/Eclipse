package com.reservation.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reservation.model.ReservationDAOImpl;
import com.reservation.model.ReservationDTO;
import com.reservation.model.RoomDTO;

@WebServlet("/reserve/resupdate")
public class ResUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ResUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		int rsno = Integer.parseInt(request.getParameter("rsno"));
		
		ReservationDTO arr= dao.resDetail(rsno);
		
		ArrayList<RoomDTO> roomarr = dao.roomList();	
		
		request.setAttribute("resArr", arr); //내가 선택한 값의 배열 
		request.setAttribute("roomArr", roomarr); //전체 방 list
		
		RequestDispatcher rd = request.getRequestDispatcher("reservationUpdate.jsp");
		rd.forward(request, response);

		

				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		ReservationDAOImpl dao = ReservationDAOImpl.getInstance();
		ReservationDTO res = new ReservationDTO();
//		String startdate=request.getParameter("startdate");
//		String enddate=request.getParameter("enddate");
//		int occupancy=0;
//		
//		
//		
//		
//		try {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
//			Date FirstDate = (Date) format.parse(startdate);
//			FirstDate = (Date) format.parse(startdate);
//
//			Date SecondDate = (Date) format.parse(enddate);
//			
//			long calDate = SecondDate.getTime() - FirstDate.getTime();
//			
//										// (24*60*60*1000) : 각 시간값에 따른 차이점
//			long calDateDays = calDate / (24*60*60*1000);
//			occupancy = (int) Math.abs(calDateDays);	
//			

			
			res.setEnddate(request.getParameter("enddate"));
			res.setGno(Integer.parseInt(request.getParameter("gno")));
			res.setId(request.getParameter("id"));
			res.setOccupancy(Integer.parseInt(request.getParameter("occupancy")));
			
		    String rsno = request.getParameter("rsno");
			
			res.setPay(request.getParameter("pay"));
			res.setRname(request.getParameter("rname"));
			res.setRsno(Integer.parseInt(rsno));
			res.setStartdate(request.getParameter("startdate"));
			res.setTot_ad(Integer.parseInt(request.getParameter("tot_ad")));
			res.setTot_ch(Integer.parseInt(request.getParameter("tot_ch")));
			
	
			dao.resUpdate(res);
			response.sendRedirect("respay?rsno="+rsno);	
	}
}
