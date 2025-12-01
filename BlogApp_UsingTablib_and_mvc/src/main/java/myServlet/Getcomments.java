package myServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Comment;
import beans.Topic;


@WebServlet("/getcomments")
public class Getcomments extends HttpServlet {
	private static final long serialVersionUID = 1L;
Connection con;
	
	public void init(ServletConfig config) throws ServletException {
	
		super.init(config);
		System.out.println("request come gettopics");
		ServletContext ctx = config.getServletContext();
		con = (Connection)ctx.getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=con.createStatement();
			String id = request.getParameter("topicid");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM comments WHERE cid=?");
			ps.setString(1, id);   // setting value for ?

			 rs = ps.executeQuery();
			
			   List<Comment> commentlist = new ArrayList<>();
			while(rs.next()) {
				 Comment t = new Comment( rs.getString(2));
				 commentlist.add(t);
			}
			
			
	
			getServletContext().setAttribute("tlist", commentlist);
			RequestDispatcher rd = request.getRequestDispatcher("/viewcomment.jsp");
   	     rd.forward(request, response);

		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally{
		try {
			rs.close();
			stmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
