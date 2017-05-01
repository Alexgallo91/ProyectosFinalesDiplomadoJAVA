<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Sesion Iniciada</title>
	<link rel="stylesheet" type="text/css" href="css/hoja1.css">
</head>
<body>
	<section id="contenido">

	<header id="cabecera">
		<h1>Sesion Iniciada</h1>
	</header>
	<nav id="menu">
		<ul>
			<li><a href="./Home.html" class="hvr-underline-from-center">Home</a></li>
			<li><a href="./Ingreso.html" class="hvr-underline-from-center">Ingreso</a></li>
			<li><a href="/Carrito/ingresar" class="hvr-underline-from-center">Estado</a></li>
			<li><a href="/Carrito/Compra" class="hvr-underline-from-center">Compra</a></li>
		</ul>
	</nav>
	<section id="principal">

		<div id="titulo">
			<h1>BIEVENIDO AL SITIO</h1>
			<div id="mensaje2">
				<p>Tu usuario es: ${sessionScope.usuario.usuario}</p>
				<p>Tu numero de cuenta es: ${sessionScope.noCuenta} </p>
			</div>
		</div>

		
	</section>
	<footer id="pie"><small>Derechos Reservados &copy; 2016</small></footer>
		
	</section>
</body>
</html>