<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="site/assets/css/xd.css">
<meta charset="ISO-8859-1">
<title>Logueate</title>
</head>
<body>
	
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:700,600' rel='stylesheet' type='text/css'>

	<form method="post" action="Login.do">
		<div class="box">
		<h1>Login Libros</h1>
		
		<input type="text" name="username" placeholder="nombre de usuario" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
		  
		<button type="submit" class="btn btn-block">Entrar ></button> <!-- End Btn -->
		  
		</div> <!-- End Box -->
	  
	</form>
	  
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js" type="text/javascript"></script>

</body>
</html>