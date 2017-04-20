<%@include file="AdminHeader.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">

			<a href="newcat" class='btn btn-primary'>Add New Category</a>

		</div>
		<div class="col-sm-1"></div>
	</div>
</div>
<br>

<script type="text/javascript" src="${js}/categoryajax.js"></script>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<table class="table table-hover" id="categorytable">
				<thead>
					<tr>
						<th>Category Name</th>
						<th></th>
						<th></th>
						
						
						
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Category Name</th>
						<th></th>
						<th></th>
						
						
					</tr>
				</tfoot>

			</table>
		</div>
	
	</div>
</div>


<%@include file="Footer.jsp"%>
