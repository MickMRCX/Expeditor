<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Expeditor</title>
		<!--Import materialize.css-->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/web/styles/materialize.min.css" media="screen,projection">
		<!--Let browser know website is optimized for mobile-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 	
			
		<!-- Font Awesome -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/web/styles/font-awesome.min.css" media="screen,projection">
		
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/web/styles/style.css" media="screen,projection">
		 
	</head>
	<body>
		<main>
			<div class="row">
				<div class="hide-on-small-only col m12">
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
				</div>
				<div class="col s4 offset-s4 deep-orange lighten-2 z-depth-2">
					<div>
					  <h3 class="center-align">Expeditor <i class="fa fa-fighter-jet"  aria-hidden="true"></i></h3>
					  <br>
					</div>
					<div class="row">
						<form action="j_security_check" method="post">
							<div class="row">
								<div class="input-field col s10 offset-s1">
									<i class="material-icons prefix fa fa-user" ></i>
									<input id="icon_prefix" class="validate" type="text" name="j_username">
									<label class="" for="icon_prefix">Identifiant</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s10 offset-s1">
									<i class="material-icons prefix fa fa-lock"></i>
									<input id="icon_key" class="validate" type="password" name="j_password">
									<label class="" for="icon_key">Mot de passe</label>
								</div>
							</div>
							<div class="center-align">
						  		<a href="#">Mot de passe oublié</a>
						  	</div>
						 	<br>
						 	<div class="center-align">
								<input type="submit" value="Connexion" class="waves-effect waves-light btn deep-purple darken-2" />
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</main>
		<footer>
			<!--Import jQuery before materialize.js-->
			<script type="text/javascript" src="${pageContext.request.contextPath}/web/javascript/jquery-2.1.1.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/web/javascript/materialize.min.js"></script>
		</footer>
	</body>
</html>