package neu.edu.controller;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class BasicHTTPSpringServlet extends HttpServlet  {


	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());

	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4927875426726190031L;



}
