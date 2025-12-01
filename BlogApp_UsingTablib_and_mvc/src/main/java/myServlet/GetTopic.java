package myServlet;

import java.io.IOException;
import java.sql.Connection;
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

import beans.Topic;


@WebServlet("/gettopics")
public class GetTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
			rs=stmt.executeQuery("select * from topic");
			   List<Topic> topiclist = new ArrayList<>();
			while(rs.next()) {
				 Topic t = new Topic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				 topiclist.add(t);
			}
			
			for (Topic name : topiclist) {
			    System.out.println(name);
			}
	
			getServletContext().setAttribute("tlist", topiclist);
			RequestDispatcher rd = request.getRequestDispatcher("/viewtopics.jsp");
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
