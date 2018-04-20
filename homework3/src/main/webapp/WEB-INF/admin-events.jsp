<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../app.css">
		<title>Incremental Game</title>
	</head>
	<body>
		<h1>Incremental Game</h1>
		<nav>
			<a href="admin-infor.html">Game Information</a>
			|
			<a href="../admin/generators">Generators</a>
			|
			<a href="events">Events</a>
		</nav>

		<a id="log" href="../admin/auth">Log out</a>

		<form action="/admin/events" method="post">
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
			
			<c:forEach items="${eventEntries}" var="event">
			<tr>
				<td>${event.getName()}</td>
				<td>${event.getDescription()}</td>
				<td>${event.getTriggerAt()}</td>
				<td>
					<a href='EditEventServlet?id=${event.getId()}'>Edit</a> | <a href='DeleteEventServlet?id=${event.getId()}'>Delete</a>

				</td>
			</tr>
			</c:forEach>

		</table>



	</body>
</html>
