<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<legend>Skills (Step 6)</legend>
		<%--
			<progress st id="progressBar"  max="<%=request.getParameter("progressMax")%>" value="<%=request.getParameter("progressStep")%>"/>
			<%=Float.valueOf(request.getParameter("progressStep"))/Float.valueOf(request.getParameter("progressMax"))*100%>%
	 --%>
	 
	<form action="<%=response.encodeURL("FrontController")%>" method="post">
	 
	 <table width="400px">
				<tr>
					<td colspan="2">
					<jsp:include page="ProgressForm.jsp">
							<jsp:param value="6" name="progressStep" />
							<jsp:param value="8" name="progressMax" />
					</jsp:include></td>
				</tr>
				
				<tr>
				
				<td>Skills:</td>
				<td>Level:</td>
				
				
				</tr>
				
				<tr>
				<td>ASP.net</td>
				<td><input type="number" size="10"  min="1" max="10" value="1" name ="Skill1"></td>
				</tr>
				
				<tr>
				<td>Java</td>
				<td><input type="number" size="10"  min="1" max="10" value="1" name ="Skill2"></td>
				</tr>
				
				<tr>
				<td>PHP</td>
				<td><input type="number" size="10"  min="1" max="10" value="1" name ="Skill3"></td>
				</tr>
				
				<tr>
				<td>Javascript</td>
				<td><input type="number" size="10"  min="1" max="10" value="1" name ="Skill4"></td>
				</tr>
				
					<tr>
					<td colspan="2" align="center">
					<span><button type="submit" name="_action" value="BACK">&lt;Back</button></span>
						<button type="submit" name="_action" value="NEXT">Next></button>
					</td>
				</tr>
				</table>		
				
	 
	 <input type="hidden" name="_page" value="SKILLS_INFORMATION">
	 </form>
		<%@ include file="Footer.html"%>
				
</body>
</html>