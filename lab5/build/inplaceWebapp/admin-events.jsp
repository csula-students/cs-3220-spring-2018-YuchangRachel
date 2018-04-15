<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../app.css">
		<title>Incremental Game</title>
	</head>
	<body>
		<h1>Incremental Game</h1>
		<nav>
			<a href="admin-infor.html">Game Information</a>
			|
			<a href="admin-generators.html">Generators</a>
			|
			<a href="admin-events.html">Events</a>
		</nav>
		<form action="" method="post">
			<label for='eventname'>Event name</label><br>
			<input name='name' id='eventname' type='text' /><br>
			<label for='eventdescrib'>Event Descrption</label><br>
			<textarea name='description' id='eventdescrib'></textarea><br>
			<label for='triggerAt'>Trigger At</label><br>
			<input name='trigger' id='triggerAt' type='number' /><br>

			<button>Add|Edit</button>
		</form>

		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Trigger At </th>
				<th>Action</th>
			</tr>

			<tr>
				<td><%=1%></td>
				<td><%=user.getAccount()%></td>
				<td><%=user.getName()%></td>
				<td><%=user.getGender()%></td>
				<td><%=user.getInterest()%></td>
				<td><%=user.getMsg()%></td>
			</tr>

		</table>



	</body>
</html>
