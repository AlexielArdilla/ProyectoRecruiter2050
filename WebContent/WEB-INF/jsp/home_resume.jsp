<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Curriculum Vitae</title>

<meta name="viewport" content="width=device-width"/>
<meta name="description" content="The Curriculum Vitae of Joe Bloggs."/>
<meta charset="UTF-8"> 


<link href='http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body id="top">
<form action="ControladorEvaluacion" method="get">
<div id="cv" class="instaFade">
	<div class="mainDetails">
		<div id="headshot" class="quickFade">
			<img src="img/avatar${candidato.avatar}.jpg" alt="Avatar" />
		</div>
		<input type="hidden" name="candidato_id" value="${candidato.id}">
		<div id="name">
			<h1 class="quickFade delayTwo">${candidato.nombre_apel}</h1>
			<h2 class="quickFade delayThree">${propuesta.cargo}</h2><input type="number" min="1" max="10" name="cabecera" required="">(1a10)
		</div>
		
		<div id="contactDetails" class="quickFade delayFour">
			<ul>
				<li>email: <a href="mailto:${curriculum.email}" target="_blank">${curriculum.email}</a></li>
				<li>web: <a href="http://${curriculum.web}">${curriculum.web}</a></li>
				<li>cell: ${curriculum.cel}</li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	
	<div id="mainArea" class="quickFade delayFive">
		<section>
			<article>
				<div class="sectionTitle">
					<h1>Lema, misión</h1>
				</div>
				
				<div class="sectionContent">
					<p>${curriculum.lema.texto}</p><input type="number" name="mision" min="1" max="10" required="">(1a10)
				</div>
			</article>
			<div class="clear"></div>
		</section>
		
		
		<section>
			<div class="sectionTitle">
				<h1>Experiencia laboral</h1>
			</div>
			
			<div class="sectionContent">
			<c:forEach items="${curriculum.experiencias}" var="experiencia">
				<article>
					<h2>${experiencia.cargo}</h2>
					<p class="subDetails">Desde:&nbsp ${experiencia.desde}&nbsp Hasta: &nbsp ${experiencia.hasta}</p>
					<p>${experiencia.texto}</p><input type="number" name="experiencia${experiencia.id}" min="1" max="10" required="">(1a10)
				</article>
			</c:forEach>
			</div>
			<div class="clear"></div>
		</section>
		
		
		<section>
			<div class="sectionTitle">
				<h1>Key Skills</h1>
			</div>
			
			<div class="sectionContent">
			<c:forEach items="${curriculum.skills}" var="skill">
				<ul class="keySkills">
					<li>${skill.texto}</li>
					<input type="number" name="skill${skill.id}" min="1" max="10"required="">(1a10)
				</ul>
				</c:forEach>
			</div>
			<div class="clear"></div>
		</section>
		
		
		<section>
			<div class="sectionTitle">
				<h1>Educación</h1>
			</div>
			
			<div class="sectionContent">
			<c:forEach items="${curriculum.educaciones}" var="educacion">
				<article>
					<h2>${educacion.colegio}</h2>
					<p class="subDetails">${educacion.calificacion}</p>
					<p>${educacion.texto}</p><input type="number" name="educacion${educacion.id}" min="1" max="10" required="">(1a10)
				</article>
				<br>
				<br>
			</c:forEach>
				<br>
				<button class="btn btn-success" type="submit">Enviar</button>
				<a href="ControladorMostrarCandidatos" class="btn btn-warning" type="button">Volver</a>
			</div>
			<div class="clear"></div>

		</section>
		
		
	</div>
</div>

</form>
</body>
</html>