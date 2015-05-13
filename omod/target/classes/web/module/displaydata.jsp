<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<link href="<c:url value="/res/bootstrap.min.css" />" rel="stylesheet">
<%@ include file="template/localHeader.jsp"%>
<openmrs:htmlInclude file="/res/bootstrap.min.css" />

<h3>Patient's Next of Kin</h3>
    <table class="table table-bordered">
    <thead>
    <tr>
        <th>National ID</th>
        <th>Spouse</th>
        <th>Country</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="patient" items="${patientData}" varStatus="status">
        <tr>
            <td>${patient.nationalId}</td>
            <td>${patient.spouse}</td>
            <td>${patient.country}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
