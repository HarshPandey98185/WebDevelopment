
<style>


progress {
	width: 90%;
	float: left;
}
</style>

<div id="progressBar" align="center">
				<progress  max="<%=request.getParameter("progressMax")%>" value="<%=request.getParameter("progressStep")%>"/>
</div>
<div style="float: right;font-size: .75em;">
	<a href="<%=response.encodeURL("FrontController")%>?_page=LOGOUT">Logout</a>
</div>


