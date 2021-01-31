package edu.servlet.WebProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dao.WebProjectDao;
import edu.dto.WebProjectDto;
import edu.factory.DaoFactory;


public class WebProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		WebProjectDto wpdto = null;
		RequestDispatcher rd = null;
		try {
			wpdto = new WebProjectDto();
			wpdto= new WebProjectDto();
			wpdto.setName(request.getParameter("name"));
			wpdto.setEmail(request.getParameter("email"));
			wpdto.setPhone(request.getParameter("number"));
			wpdto.setAddress(request.getParameter("address"));
			wpdto.setCity(request.getParameter("city"));
			wpdto.setPincode(Integer.parseInt(request.getParameter("pin")));
			wpdto.setState(request.getParameter("state"));
			wpdto.setCountry(request.getParameter("country"));
			WebProjectDao wpdao = DaoFactory.getWebProjectDao();
			if (wpdao.insertWebProject(wpdto)) {
				rd = request.getRequestDispatcher("thanks.html");
			} else
				rd = request.getRequestDispatcher("faliur.html");
		} catch (Exception e) {
			System.out.println("WebProjectServlet > doGet : " + e);
			rd = request.getRequestDispatcher("error.html");
		}
		rd.forward(request, response);
	}

}
