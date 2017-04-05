package neu.edu.controller;

import java.io.IOException;
import java.util.Arrays;

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
 * Servlet implementation class ProcessAboutInformation
 */
@WebServlet(urlPatterns = "/ProcessAboutInformation", initParams = {
		@WebInitParam(name = "BACK", 	value = "BasicInformation.jsp"),
		@WebInitParam(name = "SUCCESS", value = "Education.jsp"),
		@WebInitParam(name = "SESSION_NOT_FOUND", value = "LoginPage.jsp"),
		@WebInitParam(name = "SESSION_INVALID", value = "LoginPage.jsp")

})
public class ProcessAboutInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessAboutInformation() {
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

			String careerSummary = request.getParameter("careerSummary");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			String city = request.getParameter("CityAdd");
			String placeOfInterest = request.getParameter("Place1");
             
			userSessionInfo.getUserAddressBean().setCity(city);
			userSessionInfo.getUserAddressBean().setState(state);
			userSessionInfo.getUserAddressBean().setZip(zip);
			userSessionInfo.getUserInformationBean().setCareerSummary(careerSummary);
			userSessionInfo.getUserInformationBean().setPlaceOfInterest(placeOfInterest);

		//	System.out.println(placeOfInterest);

//			for (City.cityLocation location : City.cityLocation.values()) {
//				System.out.println(location);
//				System.out.println(Float.valueOf(location.getLat()));
//				System.out.println(Float.valueOf(location.getLongi()));
//				if (placeOfInterest.equals(location.toString())) {
//                    user.setPlaceOfInterest(placeOfInterest);
//					user.setPlaceOfInterestLat(Float.valueOf(location.getLat()));
//					user.setPlaceOfInterestLong(Float.valueOf(location.getLongi()));
//				}
//			}
			  String [] values =  request.getParameterValues("areaOfInterest");
		      for(String s: values){
		    	  
		    	  userSessionInfo.getUserInformationBean().getAreasOfInterest().add(s);
		    //	  System.out.println(s);
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

		// if(session == null){
		// status ="SESSION_NOT_FOUND";
		// request.setAttribute("login-error", "session-not-found");
		// }else{ //SESSION IS PRESENT
		//
		// // User user = (User)getServletContext().getAttribute(session);
		// User user = (User) session.getAttribute("UserSessionInfo");
		//
		// if(user ==null){
		// status = "SESSION_INVALID";
		// request.setAttribute("login-error", "session-invalid");
		//
		// }else{ // SESSION IS VALID & EXIST
		// status = "SUCCESS";
		//
		// String careerSummary = request.getParameter("careerSummary");
		// String state = request.getParameter("state");
		// String zip= request.getParameter("zip");
		// String city = request.getParameter("city");
		// String placeOfInterest = request.getParameter("Place1");
		//
		// user.setZip(zip);
		// user.setCity(city);
		// user.setState(state);
		// user.setCareerSummary(careerSummary);
		//
		//
		//
		// System.out.println(placeOfInterest);
		//
		// for(City.cityLocation location:City.cityLocation.values()){
		// System.out.println(location);
		// System.out.println(Float.valueOf(location.getLat()));
		// System.out.println(Float.valueOf(location.getLongi()));
		// if(placeOfInterest.equals(location.toString())){
		// System.out.println("here");
		// user.setPlaceOfInterestLat(Float.valueOf(location.getLat()));
		// user.setPlaceOfInterestLong(Float.valueOf(location.getLongi()));
		// }
		//
		// }
		//
		//
		//
		//
		// String [] values = request.getParameterValues("areaOfInterest");
		// for(String s: values){
		//
		// user.getAreaOfInterest().add(s);
		// System.out.println(s);
		// }
		// // Step 2: Store New values for user
		// // getServletContext().setAttribute(session, user);
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
		//

	}

}
