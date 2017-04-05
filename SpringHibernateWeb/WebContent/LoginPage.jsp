<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
html {
	width: 100%;
	height: 100%;
	overflow: hidden;
}

.login {
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -150px 0 0 -150px;
	width: 300px;
	height: 300px;
}

.btn {
	display: inline-block;
	padding: 9px 14px;
	margin-bottom: 0;
	font-size: 13px;
	line-height: 18px;
	color: #333333;
	text-align: center;
	text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
	vertical-align: middle;
	border: 1px solid #e6e6e6;
	border-radius: 4px;
}

input {
	width: 100%;
	margin-bottom: 10px;
	background: rgba(255, 255, 255, 0.3);
	border: none;
	outline: none;
	padding: 10px;
	font-size: 13px;
	color: black;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.0);
	border: 1px solid rgba(0, 0, 0, 0.3);
	border-radius: 4px;
}

.login h1 {
	color: black;
	text-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
	letter-spacing: 2px;
	text-align: center;
}

.login h4 {
	color: red;
	text-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
	letter-spacing: 1px;
	text-align: center;
}

.wrapper {
	text-align: center;
}
</style>
</head>
<body>

	<div class="login">
		<h1>Login</h1>
		<c:if test="${param['status'] == 'success'}">
			<h3 align="center">User Created Successfully!!!</h3>
		</c:if>
		<%--form method="post" action="ProcessLogin"--%>
		<form method="post" action="<%=response.encodeURL("FrontController")%>" name="_page" value="Login">
			<input type="text" name="username" placeholder="Username" required="required" /> 
			<input type="password" name="password"	placeholder="Password" required="required" />
			<div class="wrapper">
				<button type="submit" class="btn">Login</button><br/><br/>
				<a href="<%=response.encodeURL("Registration")%>">Registration</a>
			</div>
			<input type="hidden" name="_page" value="Login">
		</form>
		<%--
			String loginError = (String) request.getAttribute("login-error");
			if (loginError != null) {
				if ("username-password-mismatch".equals(loginError)) {

					out.print("<div><h4>UserName and Password Mismatch !!</h4></div>");
				}else if("session-not-found".equals(loginError)){
					%><div><h4>Session not found!!</h4></div> <%
				}else if("session-invalid".equals(loginError)){
					%><div><h4>Session invalid!!</h4></div> <%

				}
			}
		--%>
		<c:choose>
			<c:when test="${requestScope['login-error']=='username-password-mismatch'}">
				<div><h4>UserName and Password Mismatch !!</h4></div>
			</c:when>
	
		</c:choose>
		<h6 align="center">${requestScope['login-error']}</h6>
		<h6 align="center">${requestScope['message']}</h6>
	</div>

	<%session.invalidate(); %>
</body>
<body>

</body>
</html>