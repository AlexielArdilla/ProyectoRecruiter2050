<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Recruiter2050</title>

   
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <style type="text/css" href="css/style.css"></style>

  </head>
  <body style="background-color: #e3e7ed">

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button> <a class="navbar-brand" href="#"><img src="img/logoR2050_chico.png">Recruiter2050</a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">
						<li class="nav-item active">
							 <a class="nav-link" href="ControladorMostrarCandidatos">Ver candidatos <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							 <a class="nav-link" href="ControladorEstadisticas">Estadisticas</a>
						</li>
						<li class="nav-item">
							 <a class="nav-link" href="ControladorLogOut">LogOut</a>
						</li>
						<li class="nav-item dropdown">
							 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Candidatos</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="ControladorCargarCandidato">Cargar candidato</a> <a class="dropdown-item" href="ControladorBajaCandidato">Baja candidato</a> <a class="dropdown-item" href="ControladorPassCandidato">Generar Contraseña candidato</a>
								<div class="dropdown-divider">
								</div> <a class="dropdown-item" href="ControladorVerPassCandidatos">ver passwords candidatos</a>
							</div>
						</li>
					</ul>
					<form action="ControladorBuscador" class="form-inline">
						<input class="form-control mr-sm-2" name="busqueda" type="text"> 
						<button class="btn btn-primary my-2 my-sm-0" type="submit">
							Buscar por apellido
						</button>
					</form>
					<ul class="navbar-nav ml-md-auto">
						<li class="nav-item active">
							 <a class="nav-link" href="ControladorCambioPassword">Mod Contraseña <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item dropdown">
							 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Propuestas</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="ControladorCrearPropuesta">Cargar propuesta</a> <a class="dropdown-item" href="ControladorModPropuesta">Modificar propuesta</a> <a class="dropdown-item" href="ControladorBajaPropuesta">Baja a propuesta</a>
								
								<div class="dropdown-divider">
								</div> <a class="dropdown-item" href="ControladorAsignarPropuesta">Asignar propuesta</a>
								 <a class="dropdown-item" href="ControladorVerPropuestas">Ver propuestas</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>
			<div class="carousel slide" id="carousel-858699">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-858699">
					</li>
					<li data-slide-to="1" data-target="#carousel-858699">
					</li>
					<li data-slide-to="2" data-target="#carousel-858699" class="active">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap First" src="img/my1.jpg">
						<div class="carousel-caption">
							
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Second" src="img/my2.jpg">
						<div class="carousel-caption">
							
						</div>
					</div>
					<div class="carousel-item active">
						<img class="d-block w-100" alt="Carousel Bootstrap Third" src="img/my3.jpg">
						<div class="carousel-caption">
							
						</div>
					</div>
				</div> <a class="carousel-control-prev" href="#carousel-858699" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-858699" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
			</div>
		</div>
	</div>
	<hr>
	<div class="row">
		<div id="caja1"class="col-md-4">
			<h2>
				Seleccionados:
			</h2>
			<p>
				<ul>
				<li>Ver y manejar lista de candidatos seleccionados</li>
				<li>Auditar CVs</li>
			</ul>
			</p>
			<p>
				<a class="btn" href="#">Ver detalles »</a>
			</p> 
			<a href="ControladorSeleccionados" type="button" class="btn btn-success btn-block">
				IR
			</a>
		</div>
		<div id="caja2"class="col-md-4">
			<h2>
				Preseleccionados:
			</h2>
			<p>
				<ul>
					<li>
				Ver y manejar lista de candidatos preseleccionados</li>
					<li>Auditar CVs</li>
			</ul>
			</p>
			<p>
				<a class="btn" href="#">Ver detalles »</a>
			</p> 
			<a href="ControladorPreseleccionados" type="button" class="btn btn-warning btn-block">
				IR
			</a>
		</div>
		<div id="caja3" class="col-md-4">
			<h2>
				Candidatos rechazados:
			</h2>
			<p>
				<ul>
					<li>Ver y manejar lista de candidatos rechazados</li>
					<li>Auditar CVs</li>
				</ul>
			</p>
			<p>
				<a class="btn" href="#">Ver detalles »</a>
			</p> 
			<a href="ControladorRechazados" type="button" class="btn btn-danger btn-block">
				IR
			</a>
		</div>
	</div>
</div>
<footer style="text-align: center;">
	<br>
	<br>
	Designed and develped by Alejandro G. Vera® eldiosvolador@hotmail.com
	<br>
	<br>
</footer>

  </body>
</html>