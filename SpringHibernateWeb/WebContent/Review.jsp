
<%@page import="neu.edu.session.UserSessionInfo"%>
<%@page import="neu.edu.controller.FrontController"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
         uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
HttpSession session1 = request.getSession(false);
UserSessionInfo userSessionInfo = (UserSessionInfo) session.getAttribute(FrontController._USER_SESSION);

pageContext.setAttribute("AreasOfInterest", userSessionInfo.getUserInformationBean().getAreasOfInterest());
   
%>
<form action="<%=response.encodeURL("FrontController")%>" name="reviewData" method="post">
<table>
<tr>
<td><label>First Name:</label></td>
<td><%=userSessionInfo.getUserInformationBean().getFirstName()%></td>
</tr>

<tr>
<td> 
<label>Last Name:</label>
</td>
<td>
<%=userSessionInfo.getUserInformationBean().getLastName()%>
</td>
</tr>

<tr>
<td>
<label>Email::</label>
</td>
<td>
<%=userSessionInfo.getUserInformationBean().getEmail()%>
</td>
</tr>

<tr>
<td>
<label>address:</label>
</td>
<td>
<textarea rows="4" cols="50"><%=userSessionInfo.getUserAddressBean().getAddress()%></textarea>
</td>
</tr>

<tr>
<td>
<label>Lines About Yourself:</label>
</td>
<td>
<textarea rows="4" cols="50"><%=userSessionInfo.getUserInformationBean().getCareerSummary()%></textarea>
</td>
</tr>
<tr>
<td>city:<%=userSessionInfo.getUserAddressBean().getCity() %></td><td>State:<%=userSessionInfo.getUserAddressBean().getState() %></td><td>Zip:<%=userSessionInfo.getUserAddressBean().getZip() %></td>

</tr>
<tr>
<td>Place Of Interest </td>
<td><div id="googleMap1" style="width:60%;height:200px;"></div>
<script>
var lat =<%=21%>;
var lng =<%=31%>;
function myMap() {
var mapProp= {
    center:new google.maps.LatLng(lat,lng),
    zoom:4,
};
var map=new google.maps.Map(document.getElementById("googleMap1"),mapProp);
}

</script>
<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCdSdKh_XohTQeHC7ljAJNAxFdqjQOA5oY&callback=myMap"></script>
</td>
</tr>

<tr>
<td><label>Areas of Interests:</label></td>
<td>  <c:forEach items="${AreasOfInterest}" var="current"> ${current}<br/></c:forEach>
      
        </td>


</tr>


</table>

<label>location:</label><%=userSessionInfo.getUserAddressBean().getCity()%></br>

<%--

Float latitude=0f;
Float longitude=0f;

--%>



<%--



  Location delhi = new Location();
delhi.setName("NewDelhi");
delhi.setLattitude("51.508742");
delhi.setLongitude("-0.120850");

for(Location l:user.getLocationList()){
	
	if (user.getCity().equals(l.getName())){
		 latitude=Float.valueOf(l.getLattitude());
		 longitude=Float.valueOf(l.getLongitude());
	}
}

--%>


<div id="googleMap" style="width:60%;height:200px;"></div>
<script>
var lat = <%=44%>;
var lng = <%=55%>;
function myMap() {
var mapProp= {
    center:new google.maps.LatLng(lat,lng),
    zoom:5,
};
var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}

</script>
<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCdSdKh_XohTQeHC7ljAJNAxFdqjQOA5oY&callback=myMap"></script>


<label>eduHistory:</label></br>
 <table width="400px">
			
				<tr>
				<td>
				<label>University</label>
				</td>
						<td>
				<label>Course</label>
				</td>
			    <td>
				<label>GPA</label>
				</td>
				<td>
				<label>Year</label>
				</td>
				</tr>
				
				<tr>
				<td>
				<%=userSessionInfo.getUserEducationBeanList().get(0).getUniversityName() %>
				</td>
				<td>
				<%=userSessionInfo.getUserEducationBeanList().get(0).getCourseName() %>
				</td>
				<td>
				<%=userSessionInfo.getUserEducationBeanList().get(0).getGpa() %>
				</td>
				<td>
				<%=userSessionInfo.getUserEducationBeanList().get(0).getYear() %>
				</td>
				</tr>
				
				
				<tr>
				<td>
				<%=userSessionInfo.getUserEducationBeanList().get(1).getUniversityName() %>
				</td>
				<td>
				<%=userSessionInfo.getUserEducationBeanList().get(1).getCourseName() %>
				</td>
				<td>
				<%=userSessionInfo.getUserEducationBeanList().get(1).getGpa() %>
				</td>
				<td>
				<%=userSessionInfo.getUserEducationBeanList().get(1).getYear() %>
				</td>
				</tr>
				
		</table>	</br>
<label>projHist:</label></br>
 <table width="400px">
		
				<tr>
				<td>Project Name:</td>
				<td> <%=userSessionInfo.getUserProjectBeanList().get(0).getProjectName() %></td>
				</tr>
				<tr>
				<td>Description:</td>
				<td><textarea rows="4" cols="40" name="ProjDesc1"><%=userSessionInfo.getUserProjectBeanList().get(1).getProjectDescription()%></textarea></td>
				</tr>
				<tr>
				<td>Project Name:</td>
				<td> <%=userSessionInfo.getUserProjectBeanList().get(0).getProjectName() %></td>
				</tr>
				<tr>
				<td>Description:</td>
				<td><textarea rows="4" cols="40" name="ProjDesc1"><%=userSessionInfo.getUserProjectBeanList().get(1).getProjectDescription()%></textarea></td>
				</tr>
			
				</table>		
<table>

<tr>
<td>Skills</td>
</tr>
<tr>
<td>

<div class="container" >
  <h2>Skills</h2>
  <p>ASP.NET:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:<%=Integer.parseInt(userSessionInfo.getUserSkillsBean().getJava())*10  %>%">
      <%=Integer.parseInt(userSessionInfo.getUserSkillsBean().getJava())*10 %>%%
    </div>
  </div>
  <p>Java:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:<%=Integer.parseInt(userSessionInfo.getUserSkillsBean().getCsharp())*10 %>%">
      <%=Integer.parseInt(userSessionInfo.getUserSkillsBean().getCsharp())*10 %>%%
    </div>
  </div>
  <p>Php:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:<%=Integer.parseInt(userSessionInfo.getUserSkillsBean().getDotnet())*10 %>%">
      <%=Integer.parseInt(userSessionInfo.getUserSkillsBean().getDotnet())*10 %>%%
    </div>
  </div>
  <p>javascript:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:<%=Integer.parseInt(userSessionInfo.getUserSkillsBean().getHadoop())*10%>%">
      <%=Integer.parseInt(userSessionInfo.getUserSkillsBean().getHadoop())*10 %>%%
    </div>
  </div>
</div>



</td>


</tr>
<tr>
					<td colspan="2" align="center">
						<span><button type="submit" name="_action" value="BACK"> &lt;Back</button></span>
						&nbsp;
						<span><button type="submit" name="_action" value="CONFIRM">Confirm</button></span>
		
						
					</td>
				</tr>

</table>
<input type="hidden" name="_page" value="REVIEW_DATA">
</form>
</body>
</html>