<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/localHeader.jsp"%>
<openmrs:htmlInclude file="/res/bootstrap.min.css" />

<h3>Patientn</h3>
    <table class="table table-striped table-responsive table-hover">
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
