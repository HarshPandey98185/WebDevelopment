package neu.edu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import neu.edu.session.UserSessionInfo;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns = "/FrontController", initParams = {
		@WebInitParam(name 	= "SESSION_NOT_FOUND", 	        value 	= "LoginPage.jsp"),
		@WebInitParam(name 	= "SESSION_INVALID", 	        value 	= "LoginPage.jsp"), 
		@WebInitParam(name	= "REVIEW_DATA",		        value	= "ProcessReview"),
		@WebInitParam(name 	= "LOGIN", 				        value 	= "ProcessLogin"),
		@WebInitParam(name	= "BASIC_INFORMATION",      	value	= "ProcessBasicInformation"),
		@WebInitParam(name	= "ABOUT_INFORMATION",	        value	= "ProcessAboutInformation"),
		@WebInitParam(name	= "LOCATION_INFORMATION",       value	= "ProcessLocationInformation"),
		@WebInitParam(name	= "EDUCATION_INFORMATION",		value	= "ProcessEducationInformation"),
		@WebInitParam(name	= "PROJECTS_INFORMATION",		value	= "ProcessProjectsInformation"),
		@WebInitParam(name	= "SKILLS_INFORMATION",		    value	= "ProcessSkillsInformation"),
		@WebInitParam(name	= "LOGOUT",				        value	= "ProcessLogout"),

		
})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String _USER_SESSION = "userSessionInfo";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String _page = request.getParameter("_page");
		String _action = request.getParameter("_action");


		HttpSession session = request.getSession(true);

		String status;

		if (session == null || session.isNew()) {// Session is NULL
			
			//Login doesnt have a session
			if("Login".equals(_page)){
				status = "LOGIN";
			}else{
				status = "SESSION_NOT_FOUND";
				request.setAttribute("login-error", "session-not-found");
			}
		} else { // SESSION IS PRESENT

			// Managing session by Tomcat
			UserSessionInfo user = (UserSessionInfo) session.getAttribute(_USER_SESSION);

			if (user == null) {
				status = "SESSION_INVALID";
				request.setAttribute("login-error", "session-invalid");

			} else { // SESSION IS VALID & EXIST
				status = _page;
				//Setting from FC
				request.setAttribute("_action", _action);
			}
		}
		
		String url = getInitParameter(status);

		
		if ("SESSION".startsWith(status)) {
			response.sendRedirect(url);

		} else {

			RequestDispatcher rd = request.getRequestDispatcher("/" + url); 
			rd.forward(request, response);
		}


	}

}
