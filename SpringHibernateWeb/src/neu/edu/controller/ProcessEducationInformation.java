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

import neu.edu.bean.UserEducationBean;
import neu.edu.service.UserService;
import neu.edu.session.UserSessionInfo;



/**
 * Servlet implementation class ProcessEducationInformation
 */
@Controller("ProcessEducationInformation")
@WebServlet(urlPatterns="/ProcessEducationInformation",initParams = { 
		@WebInitParam(name = "BACK", 	value = "About.jsp"),
		@WebInitParam(name = "SUCCESS", value = "Projects.jsp"),
		@WebInitParam(name = "SESSION_NOT_FOUND", value = "LoginPage.jsp") ,
		@WebInitParam(name = "SESSION_INVALID", value = "LoginPage.jsp") 

})
public class ProcessEducationInformation extends  BasicHTTPSpringServlet  {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessEducationInformation() {
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
			String universityName=request.getParameter("University1");
			String courseName=request.getParameter("Course1");
			String gpa=request.getParameter("GPA1");
			String year = request.getParameter("year");
			System.out.println("Course name"+courseName);
			String universityName2=request.getParameter("University2");
			String courseName2=request.getParameter("Course2");
			String gpa2=request.getParameter("GPA2");
			String year2 = request.getParameter("year2");
			Boolean t=userService.userUpdateOrSave(userSessionInfo);
			System.out.println("T  :"+t);
			if(userService.userUpdateOrSave(userSessionInfo)){
				userSessionInfo.getUserEducationBeanList().get(0).setCourseName(courseName);
				userSessionInfo.getUserEducationBeanList().get(0).setUniversityName(universityName);
				userSessionInfo.getUserEducationBeanList().get(0).setGpa(gpa);
				userSessionInfo.getUserEducationBeanList().get(0).setYear(year);

				userSessionInfo.getUserEducationBeanList().get(1).setCourseName(courseName2);
				userSessionInfo.getUserEducationBeanList().get(1).setUniversityName(universityName2);
				userSessionInfo.getUserEducationBeanList().get(1).setGpa(gpa2);
				userSessionInfo.getUserEducationBeanList().get(1).setYear(year2);
				
			}
			else{
				UserEducationBean e1 = new UserEducationBean();
				e1.setCourseName(courseName);
				e1.setUniversityName(universityName);
				e1.setGpa(gpa);
				e1.setYear(year);
				userSessionInfo.getUserEducationBeanList().add(e1);
				UserEducationBean e2 = new UserEducationBean();
				e2.setCourseName(courseName2);
				e2.setUniversityName(universityName2);
				e2.setGpa(gpa2);
				e2.setYear(year2);
				userSessionInfo.getUserEducationBeanList().add(e2);
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
//				String universityName=request.getParameter("University1");
//				String courseName=request.getParameter("Course1");
//				String gpa=request.getParameter("GPA1");
//				String year = request.getParameter("year");
//				
//				String universityName2=request.getParameter("University2");
//				String courseName2=request.getParameter("Course2");
//				String gpa2=request.getParameter("GPA2");
//				String year2 = request.getParameter("year2");
//				
//			
//				
//				user.getEduHistory().addtoEduList(universityName, courseName, gpa,year);
//				user.getEduHistory().addtoEduList(universityName2, courseName2, gpa2,year2);
//				
//				// Step 2: Store New values for user
//				 session.setAttribute("UserSessionInfo", user);
//				
//				//Step 3 : Store session value for CLIENT
//				// request.setAttribute("_session", session);
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
