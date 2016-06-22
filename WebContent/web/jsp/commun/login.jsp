<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/web/jsp/fragments/head.jspf" %>
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
						 	<br >
						 	<br >
						 	<div class="center-align">
								<input type="submit" value="Connexion" class="waves-effect waves-light btn deep-purple lighten-1" />
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</main>
		<footer>
			<%@include file="/web/jsp/fragments/scripts.jspf" %>
		</footer>
	</body>
</html>