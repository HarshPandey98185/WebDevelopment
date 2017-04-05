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

import neu.edu.service.UserService;
import neu.edu.session.UserSessionInfo;

/**
 * Servlet implementation class ProcessLogin
 */
@Controller("ProcessLogin")
@WebServlet(name="ProcessLogin",urlPatterns = "/ProcessLogin", 
			initParams = { 
					@WebInitParam(name = "SUCCESS", value = "BasicInformation.jsp"),
					@WebInitParam(name = "FAILURE", value = "LoginPage.jsp") })
public class ProcessLogin extends BasicHTTPSpringServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("LoginPage.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = null;

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		
		Integer userId=userService.validateUser(username, password);
		
		if (userId!=null) {
			status = "SUCCESS";

			HttpSession session = request.getSession();
			
			UserSessionInfo userSessionInfo = userService.fetchUserAccountDetails(userId);
			
			if(userService.userUpdateOrSave(userSessionInfo)){
				userService.fetchEducation(userSessionInfo);
				userService.fetchProject(userSessionInfo);
				userService.fetchUserAddress(userSessionInfo);
				userService.fetchUserInfo(userSessionInfo);
			}
			else{
				
			}
			
            
			
			
			session.setAttribute(FrontController._USER_SESSION, userSessionInfo);

		} else {
			status = "FAILURE";
			request.setAttribute("login-error", "username-password-mismatch");
		}

		String url = getInitParameter(status);

		if ("ERROR".equals(status)) {
			RequestDispatcher rd = request.getRequestDispatcher("/" + url);
			rd.forward(request, response);
		} else {
			response.sendRedirect(url);
		}
	}

}
