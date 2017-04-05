<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>

button {
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

label {
	width: 100%;
	margin-bottom: 6px;
	background: rgba(255, 255, 255, 0.3);
	border: none;
	outline: none;
	padding: 10px;
	font-size: 18px;
	color: black;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.0);
	border-radius: 4px;
}

input {
	width: 100%;
	margin-bottom: 6px;
	background: rgba(255, 255, 255, 0.3);
	border: none;
	outline: none;
	padding: 10px;
	font-size: 12px;
	color: black;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.0);
	border: 1px solid rgba(0, 0, 0, 0.3);
	border-radius: 4px;
}
.body {
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -250px 0 0 -250px;
	width: 600px;
	height: 300px;
}



.body h1 {
	color: black;
	text-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
	letter-spacing: 1px;
	text-align: center;
}


.wrapper {
	text-align: center;
}
</style>
<body>
	<div class="body">

		<h1>Register User</h1>
		<form action="<%=response.encodeURL("Registration")%>" method="post">

			<table width="600px" border="0">
				<tr>
					<td><label>First Name:</label></td>
					<td><input name="firstName" type="text" /></td>
				</tr>
				<tr>
					<td><label>Last Name:</label></td>
					<td><input name="lastName" type="text" /></td>
				</tr>
				<tr>
					<td><label>User name:</label></td>
					<td><input name="username" type="text" /></td>
				</tr>
                
                <tr>
					<td><label>Password:</label></td>
					<td><input name="password" type="password" /></td>
				</tr>
				<tr>
					<td><label>Mobile:</label></td>
					<td><input name="phone" type="number" /></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><input name="email" type="email" /></td>
				</tr>


				<tr>
					<td><label>Date of Birth:</label></td>
					<td><input name="dob" type="date" /></td>
				</tr>



			

			</table>

			<div class="wrapper">
				<br />
				<button type="submit">Register</button>
				<br /> <br />
				<a href="<%=response.encodeURL("ProcessLogin")%>">Login</a>

			</div>
			<h6 align="center">${requestScope['message']}</h6>
			<h6>${requestScope['registration-error']}</h6>
		</form>
	</div>
</body>
</html>