package com.guest.action;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guest.model.GuestDAOImpl;
import com.reservation.model.ReservationDTO;

@WebServlet("/reserve/reservation")
public class ResInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    public ResInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int occupancy=0;
		
		int tot_ad=Integer.parseInt(request.getParameter("tot_ad"));
		int tot_ch=Integer.parseInt(request.getParameter("tot_ch"));
		String startdate=request.getParameter("startDate");
		String enddate=request.getParameter("endDate");
	
		try {	
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date FirstDate = (Date) format.parse(startdate);
			
			Date SecondDate = (Date) format.parse(enddate);
			
			long calDate = SecondDate.getTime() - FirstDate.getTime();
			
										// (24*60*60*1000) : 각 시간값에 따른 차이점
			long calDateDays = calDate / (24*60*60*1000);
			occupancy = (int) Math.abs(calDateDays);		
			System.out.println("occu:"+occupancy);
			String rname=request.getParameter("rname");
			
			GuestDAOImpl dao = GuestDAOImpl.getInstance();
			
			ReservationDTO res = new ReservationDTO();
			HttpSession session = request.getSession();
			int gno = (Integer) session.getAttribute("gno");

			res.setGno(gno);
			res.setOccupancy(occupancy);
			res.setTot_ad(tot_ad);
			res.setTot_ch(tot_ch);
			res.setStartdate(startdate);
			res.setEnddate(enddate);
			res.setRname(rname);
			
			dao.resInsert(res);
			
			response.sendRedirect("resForm.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
