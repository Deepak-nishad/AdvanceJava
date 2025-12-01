package listener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BlogAppListener implements ServletContextListener {

	Connection con;
	
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		String driver = ctx.getInitParameter("driverclass");
		String url = ctx.getInitParameter("jdbcurl");
		String user = ctx.getInitParameter("username");
		String pwd = ctx.getInitParameter("password");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			ctx.setAttribute("jdbccon", con);
			System.out.println("connection is done at ctx level");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
