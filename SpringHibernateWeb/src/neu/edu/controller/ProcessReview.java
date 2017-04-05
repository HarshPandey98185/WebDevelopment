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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import neu.edu.service.InformationService;
import neu.edu.session.UserSessionInfo;

/**
 * Servlet implementation class ProcessPurposeOfVisit
 * */
@Controller("ProcessReview")
@WebServlet(name="ProcessReview" ,urlPatterns = "/ProcessReview", 
			initParams = { 
							@WebInitParam(name = "BACK", 			value = "Skills.jsp"),
							@WebInitParam(name = "SUCCESS", 			value = "DisplayData.jsp"),
							@WebInitParam(name = "ACTION_MISSING", 	value = "LoginPage.jsp") 

})
public class ProcessReview extends BasicHTTPSpringServlet  {
	private static final long serialVersionUID = 1L;

@Autowired	
private InformationService informationService;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		String status = "ACTION_MISSING";
		UserSessionInfo userSessionInfo = (UserSessionInfo) session.getAttribute(FrontController._USER_SESSION);
		String _action = (String) request.getAttribute("_action");

		if ("CONFIRM".equals(_action)) {
			if(informationService.userUpdateOrSave(userSessionInfo)){
				informationService.updateDetailsForExistingUser(userSessionInfo);
				status = "SUCCESS";
			}
			else{
				
				
				
				
				
				informationService.saveInformation(userSessionInfo);
				informationService.saveEducation(userSessionInfo);
				informationService.saveProjects(userSessionInfo);
				status = "SUCCESS";
				
			}
			
			
		//	UserDao userDao = new UserDao();
		//	boolean value=userDao.checkUser(Integer.parseInt(user.getUser_id()));
		//	if(value){
				//System.out.println("user exists");
		//		userDao.updateUser(user);
			}
		//	else if{
				//System.out.println("user new");
		//		userDao.saveUser(user);
		//	}
			
		//	userDao.saveUser(user);
		//	userDao.updateUser(user);
			

		 else if("BACK".equals(_action)) {
			status = "BACK";

		}

		// Using Servlet InitParameter Mapping, the url is configured based on the status
		String url = getInitParameter(status);

		if ("ERROR".equals(status)) {
			RequestDispatcher rd = request.getRequestDispatcher("/" + url);
			rd.forward(request, response);
		} else {
			response.sendRedirect(url);
		}

	}

}
