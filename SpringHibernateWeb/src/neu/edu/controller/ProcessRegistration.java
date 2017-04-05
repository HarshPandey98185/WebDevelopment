package neu.edu.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import neu.edu.bean.UserRegistrationBean;
import neu.edu.service.RegisterService;

/**
 * Servlet implementation class ProcessRegistration
 */
@Controller("ProcessRegistration")
@WebServlet(name="ProcessRegistration",urlPatterns = "/Registration", initParams = {
		@WebInitParam(name = "SUCCESS", value = "LoginPage.jsp"),
		@WebInitParam(name = "ERROR", value = "Registration.jsp")

})
public class ProcessRegistration extends BasicHTTPSpringServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RegisterService registerService;

	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Registration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		String status = "ERROR";
		
		Boolean b =registerService.validateRegisteredUser(request.getParameter("username"), request.getParameter("password"));
		
		if(b){
			String message = "UserName and Password allready exists";
			request.setAttribute("message", message);
		}
		else{
			UserRegistrationBean userRegistration = new UserRegistrationBean();
			userRegistration.setFirstName(request.getParameter("firstName"));
			userRegistration.setLastName(request.getParameter("lastName"));
			userRegistration.setUserName(request.getParameter("username"));
			userRegistration.setPassword(request.getParameter("password"));
			userRegistration.setEmail(request.getParameter("email"));
			userRegistration.setMobileNumber(request.getParameter("phone"));
			userRegistration.setDateOfBirth(request.getParameter("dob"));
			
			Integer userId = registerService.createUser(userRegistration);
			
			if(userId!=null){
				status="SUCCESS";
				flag = true;
				String message = "Registered successfully";
				request.setAttribute("message", message);
			}
			
			
		}
		
		
		
		
		String url = getServletConfig().getInitParameter(status);

		if (flag) {
			response.sendRedirect(url + "?status=success");
		} else {
			request.getRequestDispatcher("/" + url).forward(request, response);
		}
	

	

		// What are we missing here
	}
	

}
