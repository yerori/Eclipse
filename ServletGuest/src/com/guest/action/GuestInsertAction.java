package com.guest.action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.guest.model.GuestDAO;
import com.guest.model.GuestDTO;

@WebServlet("/guestbook/create.gb")
public class GuestInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GuestInsertAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		GuestDAO dao = GuestDAO.getInstance();
		GuestDTO guest = new GuestDTO();
		guest.setName(request.getParameter("name"));
		guest.setContent(request.getParameter("content"));
		guest.setIpaddr(request.getRemoteAddr()); //★ ip주소 구해올 때 : getRemoteAddr!!!
		guest.setGrade(request.getParameter("grade"));
		
		try {
			dao.guestInsert(guest); //guestInsert문 실행
			response.sendRedirect("list.gb");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
