package controllers;






import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloControllers {
	@RequestMapping("/hello")
	public String hello() {
		return "welcome";   
	}
	
	// http://localhost:8081/SpringMvc/greet?name=Deepak
	@RequestMapping("/greet")
	public ModelAndView greet(HttpServletRequest request) {
		String nm = request.getParameter("name");	
			
		return new ModelAndView("greet","nm",nm);
	}
	
	//http://localhost:8081/SpringMVC/info
		@RequestMapping("/info")
		public String info(ModelMap map) {
			map.addAttribute("req_method", "GET");
			map.addAttribute("req_url","/info");
			map.addAttribute("req_host","localhost:8080");
			return "info";       //  /info.jsp
		}
	
	

}
