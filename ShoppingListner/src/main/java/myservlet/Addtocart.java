package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AddToCart")
public class Addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int pid = Integer.parseInt(request.getParameter("SelectedProduct"));
		HttpSession session= request.getSession();
		List<Integer> cartlist =  (List<Integer>)session.getAttribute("cart");
		System.out.println(cartlist);
		
		if(cartlist == null) {
			cartlist = new ArrayList<>();
		}
		cartlist.add(pid);
		session.setAttribute("cart", cartlist);
		out.print("<p>"+pid+" is added to the cart </p>");
		out.print("<p> There are total "+cartlist.size()+" products in the cart<p>");
		out.print("<br/><a href='home'> Select more </a>");
		out.print("<br/><a href='viewcart'> View Cart </a>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
