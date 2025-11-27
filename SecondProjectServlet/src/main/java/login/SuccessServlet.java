package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sucess")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//business logic
				PrintWriter out =response.getWriter();
				
				RequestDispatcher rd = request.getRequestDispatcher("/header");
				rd.include(request, response);
				
				out.print("<hr/><h3>This is home page</h3><hr/>");
				
				RequestDispatcher rd1 = request.getRequestDispatcher("/footer");
				rd1.include(request, response);
	}

}
