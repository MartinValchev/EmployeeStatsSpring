<%@ include file="common/header.jspf"%>

	<div class="jumbotron" id="heading">
		<h2 class="pageHeading">Add Employee</h2>
	</div>
<%@ include file="common/navigation.jspf"%>	

	<div class="tab-pane fade in active" id="contentPage">
	<div class="col-sm-6">
			<form class="form-horizontal">
				<div class="form-group">
					<label for="employeeFirstName">First
						Name:</label> <input class="form-control" type="text" id="employeeFirstName"/>
				<p class="explain_text">String format: one letter [A-Z], one or more letters [a-z]</p>
				</div>
				<div class="form-group">
					<label for="employeeLastName">Last
						Name:</label> <input type="text" class="form-control"  id="employeeLastName"/>
				<p class="explain_text">String format: one letter [A-Z], one or more letters [a-z]</p>
				</div>
				<div class="form-group">
					<label for="age">Age:</label> <input type="text" 
						class="form-control" id="age"/>
						<p class="explain_text">Age between 18-99 years</p>
				</div>
				<div class="form-group">
					<label for="lengthOfService">Length
						of Service:</label> <input type="text" class="form-control" id="lengthOfService"/>
				<p class="explain_text">number format [0-9]{2}.[0-9]{1,2}</p>
				</div>
				<br /> <br />
				<div class="form-group">
					<button type="button" id="add-Employee" class="btn btn-success"
						onclick="addEmployee()">Submit</button> 	
				</div>
			</form>
		</div>
		<div class="col-sm-6">
			<div class="panel panel-default" id="employee-added">
				<ul class="panel panel-default" id="employee-list">
				</ul>
				<%@ include file="common/employee_template.jspf"%>	
			</div>
		</div>
	</div>
	
<%@ include file="common/footer.jspf"%>