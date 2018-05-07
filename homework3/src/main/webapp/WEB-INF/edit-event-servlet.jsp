<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../app.css">
		<title>Editing Events</title>
	</head>
	<body>
		<form method="post">
			<label for="name">Name: </label><br>
			<input type="text" name="name" id="eventname" value="${name}"><br>
			<label for="eventdescrib">Event Description: </label><br>
			<textarea name="description" id="eventdescrib" value="${description}"></textarea><br>
			<label for="triggerAt">Trigger At</label><br>
			<input type="number" name="trigger" id="triggerAt" value="${triggerAt}"><br>
			<button>Add</button>
		</form>
	</body>
</html>
