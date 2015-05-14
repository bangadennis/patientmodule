<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<openmrs:htmlInclude file="/res/bootstrap.min.css" />
<%@ include file="template/localHeader.jsp"%>
<div class="row">
    <p>Welcome, ${user.systemId}!</p>
    <div class="jumbotron col-md-6 col-md-offset-3">
    <h5 class="text-center">Next of Kin Form</h5>
    <div class="form-group col-md-offset-2 col-md-8">
    <form class="" method="post"  action="<c:url value='/module/patientmodule/add.form' />">

    <label><openmrs:message code="Country"/></label>
    <br>
    <spring:bind path="patientmodule.country">
    <input type="text" class="form-control" name="country" value="${status.value}" size="35" required />
    <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
    </spring:bind>
        <br/>
    <label valign="top"><openmrs:message code="Spouse"/></label>
        <br>
    <spring:bind path="patientmodule.spouse">
    <input type="text" name="spouse" class="form-control" value="${status.value}" size="35" required/>
    <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
    </spring:bind>

    <br />
    <input type="submit" class="btn btn-md btn-success" value="<openmrs:message code="Save"/>" name="save">
    </form>
</div>
</div>

</div>
<%@ include file="/WEB-INF/template/footer.jsp"%>