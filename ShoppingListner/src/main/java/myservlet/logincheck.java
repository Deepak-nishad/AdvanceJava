package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;


@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext ctx = config.getServletContext();
		con = (Connection)ctx.getAttribute("jdbccon");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		System.out.println(uid+ " "+ pwd);
		String query = "select * from users where u_id=? and password=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1,uid);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				
				Cookie [] all = request.getCookies();
				if(all != null) {
					for(Cookie c : all) {
						if(c.getName().equals("loginerror")) {
							c.setMaxAge(0);
							response.addCookie(c);
						}
					}
				}
				
				User u = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				HttpSession session = request.getSession();
				session.setAttribute("loggedinuser", u);
				
				RequestDispatcher rd =request.getRequestDispatcher("/home");
				rd.forward(request, response);
			}
			else {
				Cookie c = new Cookie("loginerror","Wrong_ID_PWD");
				response.addCookie(c);
				
				
				response.sendRedirect("/ShoppingListner/login.jsp"); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				//con should not closed
				rs.close();
				ps.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
