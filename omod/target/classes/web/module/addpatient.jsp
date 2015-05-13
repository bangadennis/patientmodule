<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/localHeader.jsp"%>
<p>Welcome, ${user.systemId}!</p>
<div>
    <form method="post"  action="<c:url value='/module/patientmodule/add.form' />">
    <fieldset>
    <table>
    <tr>
    <td><openmrs:message code="Country"/></td>
    <td>
    <spring:bind path="patientmodule.country">
    <input type="text" name="country" value="${status.value}" size="35" />
    <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
    </spring:bind>
    </td>
    </tr>
    <tr>
    <td valign="top"><openmrs:message code="Spouse"/></td>
    <td valign="top">
    <spring:bind path="patientmodule.spouse">
    <input type="text" name="spouse" value="${status.value}" size="35" />
    <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
    </spring:bind>
    </td>
    </tr>
    </table>
    <br />
    <input type="submit" value="<openmrs:message code="Save"/>" name="save">
    </fieldset>
    </form>
</div>

<div>
    <h3>Patient's Next of KIN</h3>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>National Id</th>
            <th>Spouse</th>
            <th>Country</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="patient" items="${patientList}" varStatus="status">
            <tr>
                <td>${patient.nationalId}</td>
                <td>${patient.spouse}</td>
                <td>${patient.country}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>