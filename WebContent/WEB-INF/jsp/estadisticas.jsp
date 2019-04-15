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
 	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 	 <!-- <link href="css/bootstrap.min.css" rel="stylesheet">-->
 	  <link href="css/mdb.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
			</nav></div></div>
<div class="container">


				<div class="row">
					<div class="col-md-4 col-md-offset-4">

						<h2>Estadísticas de Candidatos R2050</h2> 
						<tr>
						<td>
						<canvas id="pieChart"></canvas>
						</td>
						<td style="text-align: justify;">
						Este gráfico muestra la proporción de candidatos seleccionados, preseleccionados y rechazados a la fecha.
						
						</td>
						</tr>
					</div>
					<div class="col-md-4"><h2>Cómo funciona Recruiter2050:</h2><h4 style="text-align: justify;">La actividad de los candidatos es monitoreada mediante estadísticas
					que son utilizadas luego, para mejorar selecionarlos y calificarlos.
					</h4></div>
					<div class="col-md-4">
					<h2>El algoritmo de calificación:</h2>
					<h4 style="text-align:justify;">Mediante el algoritmo de calificación de competencias el sistema ayuda al recruiter a seleccionar a los candidatos
					adecuados para cada posición. En una futura versión de Recruiter2050 se incluirá la opción de autoseleccionar a los candidatos.</h4>
					
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

<!-- U need to include -->
	<link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
			<script type="text/javascript"
				src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>

<!-- SCRIPTS -->
			<!-- JQuery -->
			<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
			<!-- Bootstrap tooltips -->
			<script type="text/javascript" src="js/popper.min.js"></script>
			<!-- Bootstrap core JavaScript -->
			<script type="text/javascript" src="js/bootstrap.min.js"></script>
			<!-- MDB core JavaScript -->
			<script type="text/javascript" src="js/mdb.min.js"></script>

			<script>
				//pie
				var Seleccionados = ${Seleccionados};
				var Preseleccionados = ${Preseleccionados}; 
				var Rechazados = ${Rechazados};
				var labelsTxt = ${est_listado_labels};
				
				var ctxP = document.getElementById("pieChart").getContext('2d');
				var myPieChart = new Chart(ctxP, {
					type : 'pie',
					data : {
						labels : labelsTxt,
						datasets : [ {
							data : [ Seleccionados, Preseleccionados, Rechazados ],
							backgroundColor : [ "#F7464A", "#46BFBD",
									"#FDB45C", "#4D5360" ],
							hoverBackgroundColor : [ "#FF5A5E", "#5AD3D1",
									"#FFC870", "#616774" ]
						} ]
					},
					options : {
						responsive : true
					}
				});
			</script>

  </body>
</html>