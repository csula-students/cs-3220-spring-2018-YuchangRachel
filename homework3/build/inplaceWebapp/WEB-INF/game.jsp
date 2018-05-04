<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../game.css">
		<title>Incremental game</title>
	</head>
	<body>
		<h1>Cookie Clicker</h1>

		<div class="stories">
			<game-story-book></game-story-book>
		</div>

		<game-button></game-button>

		<game-counter></game-counter>

		<div class="generators">
			<game-generator data-id="0"></game-generator>
			<game-generator data-id="1"></game-generator>
			<game-generator data-id="2"></game-generator>
		</div>


		<!-- import webcomponent polyfill for other browsers -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/webcomponentsjs/1.1.0/webcomponents-lite.js"></script>

		<script>
		  window.game = {
		  state: {
		  counter: 0
		  }
		  };

		  window.game.state = ${state}; // where state is passed from Controller as JSON string
		</script>
		<script src ='app.bundle.js'></script>
	</body>
</html>
