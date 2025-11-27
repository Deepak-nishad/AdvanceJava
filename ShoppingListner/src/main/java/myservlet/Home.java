package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class Home extends HttpServlet {
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
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("/header");
		rd.include(request, response);
		
		PrintWriter out = response.getWriter();
		out.print("<h2>Availabe catorigies</h2>");

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt=con.createStatement();
			String query="select * from category";
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				out.print("<a href='getproducts?catid="+rs.getInt(1)+"'>" + rs.getString(2)+"</a> <br>");
			}
			

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

}
