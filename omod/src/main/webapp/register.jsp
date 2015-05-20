<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/localHeader.jsp"%>
<p>Hello, ${user.systemId}!</p>
<div class="row">
    <div class="jumbotron col-md-4 col-md-offset-4">
        <h2 class="text-center">Registration</h2>
        <div class="form-group col-md-offset-2 col-md-8">
            <form class="" method="post"  action="<c:url value='/module/patientmodule/registerpatient.form' />">

                <label>National ID</label>
                <br>
                <input type="text" class="form-control" name="nationalId" value="" size="12" required />
                <br/>
                <label>First Name</label>
                <br>
                <input type="text" class="form-control" name="givenName" value="" size="35" required />
                <br>
                <label>Middle Name</label>
                <br>
                <input type="text" class="form-control" name="middleName" value="" size="35" required />
                <br>
                <label>Family Name</label>
                <br>
                <input type="text" class="form-control" name="familyName" value="" size="35" required />
                <br/>
                <label>Date of Birth</label>
                <br>
                <input type="text" class="form-control" name="dateofbirth" value="" size="35" required />
                <br/>
                <label>Gender</label>
                <select name="gender">
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                </select>
                <br/>

                <input type="submit" class="btn btn-success" value="Register">
        </form>
    </div>

</div>
<%@ include file="/WEB-INF/template/footer.jsp"%>