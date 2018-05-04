<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="game.css">
		<title>Incremental game</title>
	</head>
	<body>
		<h1>Cookie Cliker</h1>
		<div id="multipleLine" >
			<p>Cookie? Click on the button to create cookies.
			<br>
			Your cookies are talked about for miles around.
			<br>
			C is for cookie. And that is good enough for me.
			</p>
		</div>
		<div class="parent">
			<a>Cookies :</a>
			<a id='cookie'>0</a>
			<div class="child">
				<!-- <button class="button">Activate</button> -->
				<img src="http://moziru.com/images/biscuit-clipart-cute-1.jpg" alt="Activate" class="button" high=42px width=42px>
			</div>
		</div>
		<div class="flex-container">
			<div class="subgenerator">
				<div class="parent2">
					<h3>Cursor</h3>
					<label class="quantity">0</label>
				</div>
				<p>Generator Description: Initial Price:10cookies. He produces cookies at the base rate of 5 cookies per minute. </p> 
				<label class="bottomlabel">5/60</label>
				<button class="buttoninside">10 Resource</button>
			</div>
			<div class="subgenerator">
				<div class="parent2">
					<h3>Grandmom</h3>
					<label class="quantity">0</label>
				</div>
				<p>Generator Desiption: Initial Price:100cookies. She produces cookies at a base rate of 10 cookies per minute.</p>
				<label class="bottomlabel">10/60</label>
				<button class="buttoninside">100 Resource</button>
			</div>
			<div class="subgenerator">
				<div class="parent2">
					<h3>Cookie Factory</h3>
					<label class="quantity">0</label>
				</div>
				<p>Generator Description: Initial Price:500cookies. It produces cookies at a base rate of 20 cookies per minute.</p>
				<label class="bottomlabel">20/60</label>
				<button class="buttoninside">500 Resource</button>
			</div>

		</div>

		<script>
			window.game = {
			state: {
			counter: 0
			}
			};
			window.game.state = ${state}; // where state is passed from Controller as JSON string
		</script>
		<script src='app.js'></script>
	</body>
</html>

