<%--<openmrs:htmlInclude file="/moduleResources/patientmodule/css/bootstrap.min.css" />--%>
<spring:htmlEscape defaultHtmlEscape="true" />
<ul id="menu">
	<li class="first"><a
		href="${pageContext.request.contextPath}/admin"><spring:message
				code="admin.title.short" /></a></li>

	<li
		<c:if test='<%= request.getRequestURI().contains("/manage") %>'>class="active"</c:if>>
		<a
		href="${pageContext.request.contextPath}/module/patientmodule/manage.form"><spring:message
				code="List Patients" /></a>
	</li>

	<li
			<c:if test='<%= request.getRequestURI().contains("/displaydata") %>'>class="active"</c:if>>
		<a
				href="${pageContext.request.contextPath}/module/patientmodule/displaydata.form"><spring:message
				code="Display Data" /></a>
	</li>


	<li
			<c:if test='<%= request.getRequestURI().contains("/addpatient") %>'>class="active"</c:if>>
		<a
				href="${pageContext.request.contextPath}/module/patientmodule/addpatient.form"><spring:message
				code="Add Patient" /></a>
	</li>
	<li
			<c:if test='<%= request.getRequestURI().contains("/register") %>'>class="active"</c:if>>
		<a
				href="${pageContext.request.contextPath}/module/patientmodule/register.form"><spring:message
				code="Register Patient" /></a>
	</li>
	
	<!-- Add further links here -->
</ul>
<h4>
	<spring:message code="Patient's Kin" />
</h4>
