<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<legend>Education (Step 4)</legend>
		<%--
			<progress st id="progressBar"  max="<%=request.getParameter("progressMax")%>" value="<%=request.getParameter("progressStep")%>"/>
			<%=Float.valueOf(request.getParameter("progressStep"))/Float.valueOf(request.getParameter("progressMax"))*100%>%
	 --%>
	 
	<form action="<%=response.encodeURL("FrontController")%>" method="post">
	 
	 <table width="400px">
				<tr>
					<td colspan="2">
					<jsp:include page="ProgressForm.jsp">
							<jsp:param value="4" name="progressStep" />
							<jsp:param value="8" name="progressMax" />
					</jsp:include></td>
				</tr>
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
				<input type = "text" name = "University1" value="${sessionScope['userSessionInfo'].userEducationBeanList[0].universityName}">
				</td>
				<td>
				<input type = "text" name = "Course1" value="${sessionScope['userSessionInfo'].userEducationBeanList[0].courseName}">
				</td>
				<td>
				<input type = "text" name = "GPA1" value="${sessionScope['userSessionInfo'].userEducationBeanList[0].gpa}">
				</td>
				<td>
				<select name ="year">
				<option value = "1999">1999</option>
				<option value = "2000">2000</option>
				<option value = "2001">2001</option>
				
				</select>
				</td>
				</tr>
				<tr>
				<tr>
				<td>
				<input type = "text" name = "University2" value="${sessionScope['userSessionInfo'].userEducationBeanList[1].universityName}">
				</td>
				<td>
				<input type = "text" name = "Course2" value="${sessionScope['userSessionInfo'].userEducationBeanList[1].courseName}">
				</td>
				<td>
				<input type = "text" name = "GPA2" value="${sessionScope['userSessionInfo'].userEducationBeanList[1].gpa}">
				</td>
				<td>
				<select name ="year2">
				<option value = "1999">1999</option>
				<option value = "2000">2000</option>
				<option value = "2001">2001</option>
				
				</select>
				</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<span><button type="submit" name="_action" value="BACK">&lt;Back</button></span>
						<button type="submit" name="_action" value="NEXT">Next></button>
					</td>
				</tr>
		</table>		
				
	 
	 <input type="hidden" name="_page" value="EDUCATION_INFORMATION">
	 </form>
		<%@ include file="Footer.html"%>

</body>
</html>