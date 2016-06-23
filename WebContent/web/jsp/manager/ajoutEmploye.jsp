<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/web/jsp/fragments/head.jspf" %>
	<body onload="">
		<header>
			<%@include file="/web/jsp/fragments/sideNav.jspf" %>
			<%@include file="/web/jsp/fragments/topMenuBar.jspf" %>			  
    	</header>
		<main class="side">
		    <div class="row vertical-spacing-10">
		    	<form class="col s12" action="#" method="post">
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
					          <input id="nomEmploye" name="nomEmploye" type="text" class="validate">
					          <label for="nomEmploye">Nom de l'employe</label>
				        </div>
		    		</div>
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
					          <input id="loginEmploye" name="loginEmploye" type="text" class="validate">
					          <label for="loginEmploye">Login de l'employe</label>
				        </div>
		    		</div>
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
					          <input id="mdp" name="mdp" type="password" class="validate">
					          <label for="mdp">Mot de passe</label>
				        </div>
		    		</div>
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
					          <input id="mdpConfirm" name="mdpConfirm" type="password" class="validate">
					          <label for="mdpConfirm">Confirmation mot de passe</label>
				        </div>
		    		</div>
		    		<div class="row vertical-spacing-5">
						<div class="col s5 offset-s1">
							<a class="waves-effect waves-light btn btn-large btn-block #ff5252 red accent-2">annuler</a>
						</div>
						<div class="col s5 ">
							<input type="button" value="ajouter" class="waves-effect waves-light btn btn-large btn-block deep-purple lighten-1">
						</div>
		    		</div>
		    		
		    	</form>
			</div>		
			
		</main>
		<footer class="side">
			<%@include file="/web/jsp/fragments/scripts.jspf" %>			
		</footer>
	</body>
</html>