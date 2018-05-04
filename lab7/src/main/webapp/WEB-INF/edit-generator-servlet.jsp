<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../app.css">
		<title>Edit Generator: </title>
	</head>
	<body>
		<form method="post">
			<label for="generatorname">Generator Name: </label><br>
			<input type="text" name="name" id="generatorname" value="${name}"><br>
			<label for="generatorrate">Generator Rate: </label><br>
			<input type="number" name="rate" id="generatorrate" value="${rate}"><br>
			<label for="basecost">Base Cost: </label><br>
			<input type="number" name="cost" id="basecost" value="${baseCost}"><br>
			<label for="unlockat">Unlock At: </label><br>
			<input type="number" name="unlock" id="unlockat" value="${unlockAt}"><br>
			<label for="generatorDescription">Generator Description: </label><br>
			<textarea name="description" id="generatorDescription" value="${description}"></textarea><br>
			<button>Add</button>
		</form>
	</body>
</html>
