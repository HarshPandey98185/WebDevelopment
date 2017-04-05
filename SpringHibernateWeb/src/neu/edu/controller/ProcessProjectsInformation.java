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

import neu.edu.bean.UserProjectBean;
import neu.edu.service.UserService;
import neu.edu.session.UserSessionInfo;





/**
 * Servlet implementation class ProcessProjectsInformation
 */
@Controller("ProcessProjectsInformation")
@WebServlet(urlPatterns="/ProcessProjectsInformation",initParams = { 
		@WebInitParam(name = "BACK", 	value = "Education.jsp"),
		@WebInitParam(name = "SUCCESS", value = "Skills.jsp"),
		@WebInitParam(name = "SESSION_NOT_FOUND", value = "LoginPage.jsp") ,
		@WebInitParam(name = "SESSION_INVALID", value = "LoginPage.jsp") 

})
public class ProcessProjectsInformation extends BasicHTTPSpringServlet{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessProjectsInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		String status = "ACTION_MISSING";
		UserSessionInfo userSessionInfo = (UserSessionInfo) session.getAttribute(FrontController._USER_SESSION);
		String _action = (String) request.getAttribute("_action");

		if ("NEXT".equals(_action)) {
			status = "SUCCESS"; 
			if(userService.userUpdateOrSave(userSessionInfo)){
			
			userSessionInfo.getUserProjectBeanList().get(0).setProjectName(request.getParameter("ProjectName1"));
			userSessionInfo.getUserProjectBeanList().get(0).setProjectDescription(request.getParameter("ProjDesc1"));
			
			userSessionInfo.getUserProjectBeanList().get(1).setProjectName(request.getParameter("ProjectName2"));
			userSessionInfo.getUserProjectBeanList().get(1).setProjectDescription(request.getParameter("ProjDesc2"));
			}
			else{
				UserProjectBean p1 = new UserProjectBean(request.getParameter("ProjectName1"), request.getParameter("ProjDesc1"));
				userSessionInfo.getUserProjectBeanList().add(p1);
				
				UserProjectBean p2 = new UserProjectBean(request.getParameter("ProjectName2"), request.getParameter("ProjDesc2"));
				userSessionInfo.getUserProjectBeanList().add(p2);
				
				
			}
			
			
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
		
		
		
		
		
		
		
		
		
		
		
		
		
//		 HttpSession session = request.getSession(false);
//      
//		String status;
//		
//		if(session == null){
//			status ="SESSION_NOT_FOUND";
//			request.setAttribute("login-error", "session-not-found");
//		}else{ //SESSION IS PRESENT
//			
//			User user = (User) session.getAttribute("UserSessionInfo");
//			
//			if(user ==null){
//				status = "SESSION_INVALID";
//				request.setAttribute("login-error", "session-invalid");
//
//			}else{ // SESSION IS VALID & EXIST
//				status = "SUCCESS"; 
//				user.getProjHist().addProjToList(request.getParameter("ProjectName1"), request.getParameter("ProjDesc1"));
//				user.getProjHist().addProjToList(request.getParameter("ProjectName2"), request.getParameter("ProjDesc2"));
//				// Step 2: Store New values for user
//				 session.setAttribute("UserSessionInfo", user);
//				
//				//Step 3 : Store session value for CLIENT
//			//	 request.setAttribute("_session", session);
//				
//				
//			}//End of Session is valid & exists
//		}//End of Session is present
//		
//		
//		
//        String url  = getInitParameter(status);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/"+url);
//		rd.forward(request, response);
	}

}
