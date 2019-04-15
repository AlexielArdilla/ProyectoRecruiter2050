<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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

  
      <link rel="stylesheet" href="css/stylex.css">

  </head>
  <body style="background-color: #e3e7ed">

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button> <a class="navbar-brand" href="ControladorLogIn"><img src="img/logoR2050_chico.png">Recruiter2050</a>
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
								 <a class="dropdown-item" href="ControladorCargarCandidato">Cargar candidato</a> <a class="dropdown-item" href="ControladorBajaCandidato">Baja candidato</a> <a class="dropdown-item" href="ControladorPassCandidato">Generar Contrase�a candidato</a>
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
							 <a class="nav-link" href="ControladorCambioPassword">Mod Contrase�a <span class="sr-only">(current)</span></a>
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


			 <section>
  <!--for demo wrap-->
  <h1>Candidatos y Passwords</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Nombre</th>
          <th>User</th>
          <th>Password</th>
          <th>Borrar</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      <c:forEach items="${passCandidatos}" var="passCandidato">
        <tr>
          <td>${passCandidato.nombre_apel}</td>
          <td>${passCandidato.user}</td>
           <td>${passCandidato.pass}</td>
           <td><a href="ControladorVerPassCandidatos?candidato_user=${passCandidato.user}" class="btn btn-info" role="button">Borrar</a></td>
        </tr>
 		</c:forEach>
   
      </tbody>
    </table>
  </div>
</section>
<footer style="text-align: center;">
	
	<br>
	Designed and develped by Alejandro G. Vera� eldiosvolador@hotmail.com
	<br>
	<br>
</footer>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
 <script  src="js/index.js"></script>
  </body>
</html>