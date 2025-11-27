package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getproducts")
public class Getproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void init(ServletConfig config) throws ServletException {

		ServletContext context = config.getServletContext();
		
		con = (Connection)context.getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h2>Product Selection </h2>");
		int cid = Integer.parseInt(request.getParameter("catid"));
//	    out.print(cid);
	    PreparedStatement pt=null;
	    ResultSet result=null;
	    
	   
	    try {
	    	 String qeury="select * from product where cat_id=?";
	    	 pt=con.prepareStatement(qeury);
	    	 pt.setInt(1, cid);
	    	 result=pt.executeQuery();
	    	 out.print("<form action=''>");
	    	 out.print("Select product");
	    	 out.print("<select name='SelectedProduct'>");
	    	 while(result.next())
	    	 {
	    		  out.print("<option value='"+result.getInt(1)+"'>"+result.getString(2)+"</option>");
	    	 }
	    	 
	    	 out.print("</select>");
	    	 out.print("<input type='submit' value='AddToCart' />");
	    	 out.print("</form>");
	    	 
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }finally {
			    	try {
			    		result.close();
			    		pt.close();
			    	}catch(Exception e1)
			    	{
			    		e1.printStackTrace();
	          	}
	    }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
