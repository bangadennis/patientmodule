<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>


<%@ taglib prefix="openmrs" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post">
    <fieldset>
        <table>
            <tr>
                <td><openmrs:message code="general.name"/></td>
                <td>
                    <spring:bind path="patientmodule.name">
                        <input type="text" name="name" value="${status.value}" size="35" />
                        <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td valign="top"><openmrs:message code="general.name"/></td>
                <td valign="top">
                    <spring:bind path="patientmodule.spouse">
                        <input type="text" name="spouse" value="${status.value}" size="35" />
                        <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
                    </spring:bind>
                </td>
            </tr>
        </table>
        <br />
        <input type="submit" value="<openmrs:message code="patientmodule.save"/>" name="save">
    </fieldset>
</form>


<%@ include file="/WEB-INF/template/footer.jsp"%>