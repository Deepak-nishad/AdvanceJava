package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;


@WebServlet("/confirmcart")
public class ConfirmCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context = config.getServletContext();		
		con = (Connection)context.getAttribute("jdbccon");
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  
		
		//add one record in the shoppingtable
		//uid, current date time, total price
		 HttpSession session = request.getSession();
		 User user = (User)session.getAttribute("loggedinuser");
		 String uid = user.getUid();
		 float total = (Float)session.getAttribute("tprice");
		 String query = "insert into shopping(user_id, shoppingDate, totalprice) values(?, current_timestamp(), ?)";
		 PreparedStatement ps = null;
		 try {
			 ps = con.prepareStatement(query);
			 ps.setString(1, uid);
			 ps.setFloat(2, total);
			 int  n = ps.executeUpdate();
			 if(n == 1) {
				 out.print("<p> Order is conformed </p>");
				 out.print("<p> Bill will be mailed at "+user.getEmailid()+" </p>");
				 out.print("<p> You will receive the message on "+user.getContact()+" before delivery</p>");
				 out.print("<br/><br/><a href='logout'> Logout </a>");
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
			 try {
				ps.close();
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
		 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
