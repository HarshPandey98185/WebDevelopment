<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<legend>Projects (Step 5)</legend>
		<%--
			<progress st id="progressBar"  max="<%=request.getParameter("progressMax")%>" value="<%=request.getParameter("progressStep")%>"/>
			<%=Float.valueOf(request.getParameter("progressStep"))/Float.valueOf(request.getParameter("progressMax"))*100%>%
	 --%>
	 
	<form action="<%=response.encodeURL("FrontController")%>" method="post">
	 
	 <table width="400px">
				<tr>
					<td colspan="2">
					<jsp:include page="ProgressForm.jsp">
							<jsp:param value="5" name="progressStep" />
							<jsp:param value="8" name="progressMax" />
					</jsp:include></td>
				</tr>
				<tr>
				<td>Project Name:</td>
				<td> <input type = "text" name ="ProjectName1" value="${sessionScope['userSessionInfo'].userProjectBeanList[0].projectName}"></td>
				</tr>
				<tr>
				<td>Description:</td>
				<td><textarea rows="4" cols="40" name="ProjDesc1">${sessionScope['userSessionInfo'].userProjectBeanList[0].projectDescription}</textarea></td>
				</tr>
				<tr>
				<td>Project Name:</td>
				<td> <input type = "text" name ="ProjectName2" value="${sessionScope['userSessionInfo'].userProjectBeanList[1].projectName}"></td>
				</tr>
				<tr>
				<td>Description:</td>
				<td><textarea rows="4" cols="40" name="ProjDesc2" >${sessionScope['userSessionInfo'].userProjectBeanList[1].projectDescription}</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<span><button type="submit" name="_action" value="BACK">&lt;Back</button></span>
						<button type="submit" name="_action" value="NEXT">Next></button>
					</td>
				</tr>
				</table>		
				
	 
	 <input type="hidden" name="_page" value="PROJECTS_INFORMATION">
	 </form>
		<%@ include file="Footer.html"%>
				
</body>
</html>