<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="template/localHeader.jsp"%>

<p>Welcome, ${user.systemId}!</p>

<table class="table table-bordered table-responsive table-hover">
    <thead>
    <tr>
        <th>Last Name</th>
        <th>middle Name</th>
        <th>Age</th>
        <th>Gender</th>
        <th>middleName</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="patient" items="${patientList}" varStatus="status">
        <tr>
            <td>${patient.givenName}</td>
            <td>${patient.middleName}</td>
            <td>${patient.age}</td>
            <td>${patient.gender}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>