package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitCount")
public class VisitCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.write("<h2>Genearated by servlet</h2>");
	
		int n=0;
		Cookie []all=request.getCookies();
		if(all!=null) {
			for(Cookie c:all) {
				System.out.println(all[0].getName());
				if(c.getName().equals("visited")) {
					n=Integer.parseInt(c.getValue());
				}
			}
		}
		n++;
		Cookie c=new Cookie("visited", ""+ n);
		response.addCookie(c);
		out.print("visitCount is "+ n);
		out.write("<a href='visitCount'>referseh count</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
