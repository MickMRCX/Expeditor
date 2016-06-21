<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Expeditor</title>
		<!--Import Google Icon Font-->
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<!--Import materialize.css-->
		<link type="text/css" rel="stylesheet" href="../../styles/materialize.min.css" media="screen,projection">
		<!--Let browser know website is optimized for mobile-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 	
		
		<link type="text/css" rel="stylesheet" href="../../styles/style.css" media="screen,projection">
		 
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
					  <h3 class="center-align">Connexion</h3>
					  <br>
					</div>
					<div class="row">
						<form class="">
							<div class="row">
								<div class="input-field col s10 offset-s1">
									<i class="material-icons prefix">account_circle</i>
									<input id="icon_prefix" class="validate" type="text">
									<label class="" for="icon_prefix">Identifiant</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s10 offset-s1">
									<i class="material-icons prefix">vpn_key</i>
									<input id="icon_key" class="validate" type="password">
									<label class="" for="icon_key">Mot de passe</label>
								</div>
							</div>
							<div class="center-align">
						  		<a href="#">Mot de passe oublié</a>
						  	</div>
						 	<br>
						 	<div class="center-align">
								<a class="waves-effect waves-light btn deep-purple darken-2">Connexion</a>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</main>
		<footer>
			<!--Import jQuery before materialize.js-->
			<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
			<script type="text/javascript" src="../../javascript/materialize.min.js"></script>
		</footer>
	</body>
</html>