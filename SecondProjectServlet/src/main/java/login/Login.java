package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/shoppingdb";
			con = DriverManager.getConnection(jdbcUrl, "root", "Deepak@123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String pass = request.getParameter("pass");

//	out.write(uid+ " "+ pass);
		System.out.println(uid+ " "+ pass);
//		if(uid.equals("deepak") && pass.equals("deepak@123")) {
//			out.write("<h1>Login succesfull</h1>");
//		}
//		else {
//			out.write("<h1>Not  succesfull</h1>");
//		}
		
		String query="select * from users where u_id=? and password=?";
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, uid);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			if(rs.next()) {
//				out.write("<h1>Login succesfull</h1>");
				RequestDispatcher rd= request.getRequestDispatcher("/sucess");
				rd.forward(request, response);
			}
			else {
//				out.write("<h1> not succesfull</h1>");
				response.sendRedirect("/SecondProjectServlet/login.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
