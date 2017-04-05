package neu.edu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import neu.edu.session.UserSessionInfo;





/**
 * Servlet implementation class ProcessBasicInformation
 */
@WebServlet(urlPatterns="/ProcessBasicInformation", 
			initParams = { 
							@WebInitParam(name = "SUCCESS",           value = "About.jsp"),
							@WebInitParam(name = "SESSION_NOT_FOUND", value = "LoginPage.jsp") ,
							@WebInitParam(name = "SESSION_INVALID", value = "LoginPage.jsp") 

			})
public class ProcessBasicInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessBasicInformation() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	req.getRequestDispatcher("BasicInformation.jsp").forward(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Step 1: Get Session ID.
//		String session  = request.getParameter("_session");
	
//		String session = null;
//		Cookie cookies[] = request.getCookies();
//		if(cookies != null){
//				for(Cookie cookie:cookies){
//					if("_session".equals(cookie.getName())){
//							session = cookie.getValue();
//					}
//				}
//		}
		
		
		
		HttpSession session = request.getSession(false);
		String status="ACTION_MISSING";
		UserSessionInfo userSessionInfo = (UserSessionInfo) session.getAttribute(FrontController._USER_SESSION);
		String _action = (String)request.getAttribute("_action");
		
		if("NEXT".equals(_action)){
			status = "SUCCESS"; 
			
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			userSessionInfo.getUserInformationBean().setFirstName(firstName);
			userSessionInfo.getUserInformationBean().setLastName(lastName);
			userSessionInfo.getUserInformationBean().setEmail(email);
			userSessionInfo.getUserInformationBean().setMobileNumber(phone);
			userSessionInfo.getUserAddressBean().setAddress(address);
		    
		    session.setAttribute(FrontController._USER_SESSION, userSessionInfo);
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
		
		
		
//		if(session == null){
//			status ="SESSION_NOT_FOUND";
//			request.setAttribute("login-error", "session-not-found");
//		}else{ //SESSION IS PRESENT
//			
//			User user = (User) session.getAttribute("UserSessionInfo");
//			if(user ==null){
//				status = "SESSION_INVALID";
//				request.setAttribute("login-error", "session-invalid");
//
//			}else{ // SESSION IS VALID & EXIST
//				status = "SUCCESS"; 
//				
//				String firstName = request.getParameter("firstName");
//				String lastName = request.getParameter("lastName");
//				String email = request.getParameter("email");
//				String address = request.getParameter("address");
//				
//				user.setFirstName(firstName);
//				user.setLastName(lastName);
//			    user.setEmail(email);
//			    user.setAddress(address);
//				
//				// Step 2: Store New values for user
//			//	getServletContext().setAttribute(session, user);
//			    session.setAttribute("UserSessionInfo", user);
//				
//				//Step 3 : Store session value for CLIENT
//				//request.setAttribute("_session", session);
//				
//				
//			}//End of Session is valid & exists
//		}//End of Session is present
//		
//		//Using Servlet InitParameter Mapping, the url is configured based on the status 
//		String url  = getInitParameter(status);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/"+url);
//		rd.forward(request, response);
	
	}

}
