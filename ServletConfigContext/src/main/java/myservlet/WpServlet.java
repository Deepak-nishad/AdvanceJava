package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/wp" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "web technology")
		})
public class WpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ServletConfig config = this.getServletConfig();
		String sub = config.getInitParameter("subject");
		
		ServletContext ctx = this.getServletContext();
		String provider = ctx.getInitParameter("provider");
		
		PrintWriter out = response.getWriter();
		out.print("<h2> Training  on "+sub+" provided by "+provider+"</h2>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
