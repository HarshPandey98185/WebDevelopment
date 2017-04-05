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
 * Servlet implementation class ProcessSkillsInformation
 */
@WebServlet(urlPatterns = "/ProcessSkillsInformation", initParams = {
		@WebInitParam(name = "BACK", 	value = "Skills.jsp"),
		@WebInitParam(name = "SUCCESS", value = "Review.jsp"),
		@WebInitParam(name = "SESSION_NOT_FOUND", value = "LoginPage.jsp"),
		@WebInitParam(name = "SESSION_INVALID", value = "LoginPage.jsp")

})
public class ProcessSkillsInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessSkillsInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		String status = "ACTION_MISSING";
		UserSessionInfo userSessionInfo = (UserSessionInfo) session.getAttribute(FrontController._USER_SESSION);
		String _action = (String) request.getAttribute("_action");

		if ("NEXT".equals(_action)) {
			status = "SUCCESS";
			userSessionInfo.getUserSkillsBean().setJava(request.getParameter("Skill1"));
			userSessionInfo.getUserSkillsBean().setCsharp(request.getParameter("Skill2"));
			userSessionInfo.getUserSkillsBean().setDotnet(request.getParameter("Skill3"));
			userSessionInfo.getUserSkillsBean().setHadoop(request.getParameter("Skill4"));
		
			session.setAttribute(FrontController._USER_SESSION, userSessionInfo);
		}
		
		else if ("BACK".equals(_action)){
			status = "BACK";

		}
		String url = getInitParameter(status);

		// RequestDispatcher rd = request.getRequestDispatcher("/"+url);
		// rd.forward(request, response);

		if ("ERROR".equals(status)) {
			RequestDispatcher rd = request.getRequestDispatcher("/" + url);
			rd.forward(request, response);
		} else {
			response.sendRedirect(url);
		}

		//
		// HttpSession session = request.getSession(false);
		//
		// String status;
		//
		// if(session == null){
		// status ="SESSION_NOT_FOUND";
		// request.setAttribute("login-error", "session-not-found");
		// }else{ //SESSION IS PRESENT
		//
		// User user = (User) session.getAttribute("UserSessionInfo");
		//
		// if(user ==null){
		// status = "SESSION_INVALID";
		// request.setAttribute("login-error", "session-invalid");
		//
		// }else{ // SESSION IS VALID & EXIST
		// status = "SUCCESS";
		//
		// user.getSkills().add(request.getParameter("Skill1"));
		// user.getSkills().add(request.getParameter("Skill2"));
		// user.getSkills().add(request.getParameter("Skill3"));
		// user.getSkills().add(request.getParameter("Skill4"));
		//
		// // Step 2: Store New values for user
		// session.setAttribute("UserSessionInfo", user);
		//
		// //Step 3 : Store session value for CLIENT
		// // request.setAttribute("_session", session);
		//
		//
		// }//End of Session is valid & exists
		// }//End of Session is present
		//
		//
		//
		// String url = getInitParameter(status);
		//
		// RequestDispatcher rd = request.getRequestDispatcher("/"+url);
		// rd.forward(request, response);

	}

}
