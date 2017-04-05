<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script>

function valthisform() {
	var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	var checkedOne = Array.prototype.slice.call(checkboxes).some(x => x.checked);

    if (checkedOne >= 1) {
    	return true;
    }
    else{
  alert ("Please chose 1 arrea of interest"+checkedOne);
        }
    return false;
}





</script>
<title>Insert title here</title>
</head>
<body>
<legend>About (Step 2)</legend>
		<%--
			<progress st id="progressBar"  max="<%=request.getParameter("progressMax")%>" value="<%=request.getParameter("progressStep")%>"/>
			<%=Float.valueOf(request.getParameter("progressStep"))/Float.valueOf(request.getParameter("progressMax"))*100%>%
	 --%>
	 
	 <form name ="FC" action="<%=response.encodeURL("FrontController")%>" method="post"  onsubmit="return valthisform();">
	 
	 <table width="400px">
				<tr>
					<td colspan="2">
					<jsp:include page="ProgressForm.jsp">
							<jsp:param value="2" name="progressStep" />
							<jsp:param value="8" name="progressMax" />
					</jsp:include></td>
				</tr>
				<tr>
					<td><label>Lines about yourself:</label></td>
					<td><textarea rows="8" cols="40" name="careerSummary">${sessionScope['userSessionInfo'].userInformationBean.careerSummary}</textarea></td>
				</tr>
				<tr>
					<td><label>City:</label></td>
					<td><input name="city" type="text" value="${sessionScope['userSessionInfo'].userAddressBean.city}"/></td>
					<td><select name ="CityAdd" >
				        <option value = "Melbourne">Melbourne</option>
				        <option value = "Delhi">Delhi</option>
				        <option value = "Tokyo">Tokyo</option>
				
				</select></td>
				</tr>
				<tr>
					<td><label>state:</label></td>
					<td><input name="state" type="text" value="${sessionScope['userSessionInfo'].userAddressBean.state}"/></td>
				</tr>
				<tr>
					<td><label>zip:</label></td>
					<td><input name="zip" type="text" value="${sessionScope['userSessionInfo'].userAddressBean.zip}"/></td>
				</tr>
				<tr>
				<td><label>Select Places of Interest:</label></td>
				<td><select name ="Place1" >
				<option value = "Melbourne">Melbourne</option>
				<option value = "Delhi">Delhi</option>
				<option value = "Tokyo">Tokyo</option>
				
				</select></td>
				</tr>
				<tr>
					<td><label>Area of interest:</label></td>
					<td><input type="checkbox" name="areaOfInterest" value="Mathematics"> Mathematics<br>
                        <input type="checkbox" name="areaOfInterest" value="Music" > Music<br>
                        <input type="checkbox" name="areaOfInterest" value="Science" > Science<br>
                        <input type="checkbox" name="areaOfInterest" value="Literature" > Literature<br>
                    </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					    <span><button type="submit" name="_action" value="BACK">&lt;Back</button></span>
						<button type="submit" name="_action" value="NEXT" >Next></button>
					</td>
				</tr>
		</table>		
				
	 <input type="hidden" name="_page" value="ABOUT_INFORMATION">
	 
	 </form>
		<%@ include file="Footer.html"%>
</body>
</html>