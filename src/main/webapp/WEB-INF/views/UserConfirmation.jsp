 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Header.jsp"%>
<div class="content">
			<div class="container-fluid">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
<h3 style="color:#D35A40;">Conform Details</h3>
					<form:form modelAttribute="registerModel">
					<div class="form-group">
							<label for="userName">UserName</label>
							<form:input path="users.userName" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="email">Email</label>
							<form:input path="users.email" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="mobile">Mobile</label>
							<form:input path="users.mobile" class="form-control" readonly="true" />
						</div>
						<div>User Address</div>
						<div class="form-group">
							<label for="houseNo">House Number</label>
							<form:input path="userAddress.houseNo" class="form-control" readonly="true"/>
						</div>
						<div class="form-group">
							<label for="street">Street</label>
							<form:input path="userAddress.street" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="city">City</label>
							<form:input path="userAddress.city" class="form-control" readonly="true"/>
						</div>
						<div class="form-group">
							<label for="state">State</label>
							<form:input path="userAddress.state" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="country">Country</label>
							<form:input path="userAddress.country" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="pin">PIN</label>
							<form:input path="userAddress.pin" class="form-control"  readonly="true"/>
						</div>
						
						<div>Billing Address</div>
						<div class="form-group">
							<label for="houseNo">House Number</label>
							<form:input path="billingAddress.houseNo" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="street">Street</label>
							<form:input path="billingAddress.street" class="form-control" readonly="true"/>
						</div>
						<div class="form-group">
							<label for="city">City</label>
							<form:input path="billingAddress.city" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="state">State</label>
							<form:input path="billingAddress.state" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="country">Country</label>
							<form:input path="billingAddress.country" class="form-control" readonly="true"  />
						</div>
						<div class="form-group">
							<label for="pin">PIN</label>
							<form:input path="billingAddress.pin" class="form-control" readonly="true"/>
						</div>
						<center><input name="_eventId_edit" type="submit" value="Edit" class="btn btn-info"/>
						<input name="_eventId_submit" type="submit"
							value="Confirm Details" class="btn btn-primary" />
							<input name="_eventId_cancel" type="submit"
							value="Cancel" class="btn btn-danger" /></center>
						<br />
				
 
 

 </form:form>




				</div>
				<div class="col-sm-4"></div>


			</div>





		</div>
		<%@include file="Footer.jsp"%>