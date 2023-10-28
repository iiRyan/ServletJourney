<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdn.tailwindcss.com"></script>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/budget.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="title-container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success"
							data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
								New Budget</span></a>
					</div>
				</div>
			</div>

		</div>
	</div>

	</div>

	<div class="card-container">
		<c:forEach var="budget" items="${budgets}">

			<a
				href="../expenses/list?budget_id=${budget.budget_id}&budget_amount=${budget.amount}">
				<div class="card">
					<p class="Name-9999">${budget.date}</p>
					<p class="Price-9999"></p>
					<p class="Name-9999">${budget.amount}$</p>
			</a>
	</div>
	</c:forEach>
	</div>

	<!-- Add Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="../budgets/add" method="POST">
					<div class="modal-header">
						<h4 class="modal-title">Add Employee</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">

							<div>
								<label for="HeadlineAct"
									class="block font-medium text-gray-900"> Nonth </label> 
									
									<select  id="HeadlineAct" name="month" class="mt-1.5 w-full rounded-lg border-gray-300 text-gray-700 ">
									<option value="">Please select a Month</option>
									<option value="jan">January</option>
									<option value="feb">February</option>
									<option value="march">March</option>
									<option value="april">April </option>
									<option value="may">May</option>
									<option value="jun">June</option>
									<option value="jul">July</option>
									<option value="aug">August</option>
									<option value="sep">September</option>
									<option value="nov">November</option>
									<option value="dec">December</option>
								</select>
							</div>

							<label>Budget</label> <input type="number" name="amount" class="form-control"
								required>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="submit"
								class="btn btn-success" value="Add">
						</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<h4 class="modal-title">Edit Employee</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Name</label> <input type="text" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label>Email</label> <input type="email" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label>Address</label>
							<textarea class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Phone</label> <input type="text" class="form-control"
								required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit" class="btn btn-info"
							value="Save">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>