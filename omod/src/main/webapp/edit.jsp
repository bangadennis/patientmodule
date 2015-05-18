<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<openmrs:htmlInclude file="/res/bootstrap.min.css" />
<%@ include file="template/localHeader.jsp"%>
<div class="row">
    <p>Welcome, ${user.systemId}!</p>
    <div class="jumbotron col-md-6 col-md-offset-3">
        <h5 class="text-center">Patient Edit</h5>
        <div class="form-group col-md-offset-2 col-md-8">
            <form class="" method="post"  action="<c:url value='/module/patientmodule/addedit.form' />">

                <spring:bind path="patient.PatientId">
                <input type="hidden" class="form-control" name="patientId" value="${patient.patientId}" size="35" required />
                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
                </spring:bind>

                <label><openmrs:message code="First Name"/></label>
                <br>
                <spring:bind path="patient.givenName">
                    <input type="text" class="form-control" name="lname" value="${patient.givenName}" size="35" required />
                    <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
                </spring:bind>
                <br/>
                <label><openmrs:message code="MiddleName"/></label>
                <br>
                <spring:bind path="patient.middleName">
                    <input type="text" class="form-control" name="middleName" value="${patient.middleName}" size="35" required />
                    <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
                </spring:bind>
                <br/>
                <label><openmrs:message code="Date of Birth"/></label>
                <spring:bind path="patient.birthdate">
                    <input type="text" name="age" class="form-control" value="${patient.birthdate}" size="35" required/>
                    <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
                </spring:bind>
                <br />
                <label valign="top"><openmrs:message code="Gender"/></label>
                <br>
                <spring:bind path="patient.gender">
                    <input type="text" name="gender" class="form-control" value="${patient.gender}" size="35" required/>
                    <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
                </spring:bind>
                <br />
                <input type="submit" class="btn btn-md btn-success" value="<openmrs:message code="Save"/>" name="save">
            </form>
        </div>
    </div>

</div>
<%@ include file="/WEB-INF/template/footer.jsp"%>