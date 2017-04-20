<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Header.jsp"%>

		<div class="content">
			<div class="container-fluid">

				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
					<h3 style="color:#D35A40;">BillingAddress</h3>
						<form:form method="post" 
							modelAttribute="userAddress">
							<div class="form-group">
								<label for="userName">House No</label>
								<form:input path="houseNo" class="form-control" />
								<form:errors path="houseNo"></form:errors>

							</div>
							<div class="form-group">
								<label for="street">Street</label>
								<form:input path="street" class="form-control" />
								<form:errors path="street"></form:errors>
							</div>
							<div class="form-group">
								<label for="city">City</label>
								<form:input path="city" class="form-control" />
								<form:errors path="city"></form:errors>
							</div>
							<div class="form-group">
								<label for="state">State</label>
								<form:input path="state" class="form-control" />
								<form:errors path="state"></form:errors>
							</div>
							<div class="form-group">
								<label for="country">Country</label>
								<form:input path="country" class="form-control" />
								<form:errors path="country"></form:errors>
							</div>
							<div class="form-group">
								<label for="pin">PIN Code</label>
								<form:input path="pin" class="form-control" />
								<form:errors path="pin"></form:errors>
								</div>
								
							
<center>

							<input type="submit" name="_eventId_submit"
								class="btn btn-primary" value="SUBMIT">

							<input type="submit" name="_eventId_cancel" class="btn btn-danger" value="CANCEL">
							</center>
						</form:form>



					</div>
					<div class="col-sm-4"></div>
				</div>

			</div>
		</div>

<%@include file="Footer.jsp"%>