<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<legend>Basic Information (Step 1)</legend>
		<%--
			<progress st id="progressBar"  max="<%=request.getParameter("progressMax")%>" value="<%=request.getParameter("progressStep")%>"/>
			<%=Float.valueOf(request.getParameter("progressStep"))/Float.valueOf(request.getParameter("progressMax"))*100%>%
	 --%>
		
		<form action="<%=response.encodeURL("FrontController")%>" method="post">
			<table width="400px">
				<tr>
					<td colspan="2">
					<jsp:include page="ProgressForm.jsp">
							<jsp:param value="1" name="progressStep" />
							<jsp:param value="8" name="progressMax" />
					</jsp:include></td>
				</tr>
				<tr>
					<td><label>First Name:</label></td>
					<td><input name="firstName" type="text" value="${sessionScope['userSessionInfo'].userInformationBean.firstName}" /></td>
				</tr>
				<tr>
					<td><label>Last Name:</label></td>
					<td><input name="lastName" type="text"  value="${sessionScope['userSessionInfo'].userInformationBean.lastName}"/></td>
				</tr>
				<tr>
					<td><label>Address Name:</label></td>
					<td><textarea rows="4" cols="40" name="address">${sessionScope['userSessionInfo'].userAddressBean.address}</textarea></td>
				</tr>
				<tr>
					<td><label>Mobile Num:</label></td>
					<td><input type="text" name="phone" value="${sessionScope['userSessionInfo'].userInformationBean.mobileNumber}"></td>
				</tr>
				<tr>
					<td><label>E-mail:</label></td>
					<td><input type="email" name="email" value="${sessionScope['userSessionInfo'].userInformationBean.email}"></td>
				</tr>
				
				
  
				<tr>
					<td colspan="2" align="center">
						<button type="submit" name="_action" value="NEXT">Next></button>
					</td>
				</tr>

			</table>
			<!-- User for hidden Param -->
			<%--  
			<input type="hidden" name="_session" value="<%=request.getAttribute("_session")%>"/>
			--%>
			<input type="hidden" name="_page" value="BASIC_INFORMATION">
		</form>
		<%@ include file="Footer.html"%>

	</fieldset>

</body>
</html>