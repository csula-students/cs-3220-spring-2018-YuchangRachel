<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Log In</title>
  <link rel="stylesheet" type="text/css" href="../app.css">
</head>
<body>
  <main>
    <h1> Incremental Game Framework </h1>
    <form method="POST" id="loginForm">
      <label>Username:</label>
      <div><input type="text" id="username" name="username"/></div>

      <label>Password:</label>
      <div><input type="text" id="username" name="password"/></div>
      <button> Log In </button>
    </form>
  </main>
</body>
</html>
