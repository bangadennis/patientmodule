<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/localHeader.jsp"%>
<div class="row">
    <div class="jumbotron col-md-8 col-md-offset-2">
        <h2 class="text-center">Edit Patient</h2>
        <div class="form-group col-md-offset-2 col-md-8">
            <form class="form-horizontal" method="post"  action="<c:url value='/module/patientmodule/addedit.form' />">
                <div class="row">
                    <label>Name</label><br/>
                    <div class="col-md-4">
                        <input type="text" class="form-control" name="givenName" placeholder="Given Name" value="${patient.givenName}" size="30" required />
                    </div>

                    <div class="col-md-4">
                        <input type="text" class="form-control" name="middleName"  placeholder="Middle Name" value="${patient.middleName}" size="25" required />
                    </div>

                    <div class="col-md-4">
                        <input type="text" class="form-control" name="familyName" placeholder="Family Name" value="${patient.familyName}" size="30" required />
                    </div>
                </div>

                <div class="form-group">
                    <%--<label>National ID</label>--%>
                    <input type="hidden" class="form-control" name="patientId" value="${patient.patientId}" size="12" maxlength="8" required />
                </div>

                <div class="form-group">
                    <label>Date of Birth</label>
                    <input type="datetime" class="form-control" name="dateofbirth" value="${patient.birthdate}" size="35" required />
                </div>

                <div class="form-group">
                    <label>Gender</label>
                    <label class="radio-inline">
                        <input type="radio" name="gender"  value="M"> Male
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="gender"  value="F"> Female
                    </label>
                </div>
                <div class="row">
                    <label>Personal Address</label><br>
                    <div class="col-md-4">
                        <input type="text" class="form-control" name="address" placeholder="Address" value="${patient.personAddress.address1}" size="30" required />
                    </div>
                    <div class="col-md-4">
                        <input type="text" class="form-control" name="city" placeholder="City" value="${patient.personAddress.cityVillage}" size="25" required />
                    </div>

                    <div class="col-md-4">
                        <input type="text" class="form-control" name="postalcode" placeholder="Postal Code" value="${patient.personAddress.postalCode}" size="30" required />
                    </div>

                </div>

                <div class="form-group">
                    <label>Country</label>
                    <input type="text" class="form-control" name="country" value="${patient.personAddress.country}" size="10" maxlength="40" required />
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>

            </form>
        </div>

    </div>
<%@ include file="/WEB-INF/template/footer.jsp"%>