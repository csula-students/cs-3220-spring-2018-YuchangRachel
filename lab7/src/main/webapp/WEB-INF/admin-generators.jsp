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
			<a href="generators">Generators</a>
			|
			<a href="../admin/events">Events</a>
		</nav>

		<a id="log" href="../admin/auth">Log out</a>

		<form method="post">
			<label for="generatorname">Generator Name</label><br>
			<input type="text" name="name" id="generatorname"><br>
			<label for="generatorrate">Generator Rate</label><br>
			<input type="number" name="rate" id="generatorrate"><br>
			<label for="basecost">Base Cost</label><br>
			<input type="number" name="cost" id="basecost"><br>
			<label for="unlockat">Unlock at</label><br>
			<input type="number" name="unlock" id="unlockat"><br>
			<label for="generatorDescription">Description</label><br>
			<textarea name="description" id="generatorDescription"></textarea><br>
			<button>Add|Edit</button>
		</form>

		<table>
			<tr>
				<th>Name</th>
				<th>Rate</th>
				<th>Cost</th>
				<th>Unlock At</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${generatorEntries}" var="generator">
			<tr>
				<td>${generator.getName()}</td>
				<td>${generator.getRate()}</td>
				<td>${generator.getBaseCost()}</td>
				<td>${generator.getUnlockAt()}</td>
				<td>${generator.getDescription()}</td>
				<td>
					<a href='EditGeneratorServlet?id=${generator.getId()}'>Edit</a> | <a href='DeleteGeneratorServlet?id=${generator.getId()}'>Delete</a>

				</td>
			</tr>
			</c:forEach>

		</table>



	</body>
</html>
