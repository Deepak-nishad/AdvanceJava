package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewcart")
public class Viewcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext context = config.getServletContext();		
		con = (Connection)context.getAttribute("jdbccon");
	}


	public Viewcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		List<Integer> cartlist = (List<Integer>)session.getAttribute("cart");
		if(cartlist == null) {
			out.print("<p> No products are selected </p>");
		}
		else {
			String query = "select * from product where p_id= ?";
			PreparedStatement ps = null;
			ResultSet rs =null;
			try {
				ps = con.prepareStatement(query);
				out.println("<table border=1>");
				float total = 0;
				for(int n : cartlist) {
					ps.setInt(1, n);
					rs = ps.executeQuery();
					rs.next();
					out.print("<tr>");
					out.print("<td>"+ rs.getString(2)+ "</td>");
					out.print("<td>"+ rs.getString(3)+ "</td>");
					total += rs.getFloat(4);
					out.print("<td>"+ rs.getFloat(4) + "</td>");
					out.print("<td>  <a href='deletefromcart?pid="+n+"'>delete</a> </td>");
					out.print("</tr>");
				}
				out.print("<tr>");
				out.print("<td colspan=2>Total price </td>");
				out.print("<td>"+total+"</td>");
				out.print("</tr>");				
				out.print("</table>");
				session.setAttribute("tprice", total);
				out.print("<br/><br/><a href='home'> Select more </a>");
				out.print("<br/><br/><a href='confirmcart'> Confirm Cart </a>");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
