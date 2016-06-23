<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="model.Utilisateur" %>
	<%@include file="/web/jsp/fragments/head.jspf" %>
	<body onload="">
		<header>
			<%@include file="/web/jsp/fragments/sideNav.jspf" %>
			<%@include file="/web/jsp/fragments/topMenuBar.jspf" %>			  
    	</header>
		<main class="side">
		    <div class="row vertical-spacing-10">
		    	<% 
		    	Utilisateur employe = null;
		    	if(request.getAttribute("user")!= null){ 
		    		employe = (Utilisateur) request.getAttribute("user");
		    	}
		    	%>
		    	<form id="formEmploye" class="col s12" action="${pageContext.request.contextPath}/GestionEmploye" method="post">
		    		<%if( employe != null){%>
		    			<input type="hidden" value="<%=employe.getIdentifiant()%>" name="id">
		    			<input type="hidden" value="modify" name="action">
		    			<input type="hidden" value="<%=employe.getLogin()%>" name="ancienLoginEmploye">
		    		<%}else{%>
		    			<input type="hidden" value="add" name="action">
		    		<%} %>
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
		    				  <%if( employe != null){%>
					          <input id="nomEmploye" name="nomEmploye" type="text" class="validate" value="<%=employe.getNom()%>">
					          <%}else{ %>
					          <input id="nomEmploye" name="nomEmploye" type="text" class="validate">
					          <%} %>
					          <label for="nomEmploye">Nom de l'employe</label>
				        </div>
		    		</div>
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
		    				  <%if( employe != null){%>
					          <input id="loginEmploye" name="loginEmploye" type="text" value="<%=employe.getLogin()%>" class="validate">
					          <%}else{ %>
					          <input id="loginEmploye" name="loginEmploye" type="text" class="validate">
					          <%} %>
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
							<a class="waves-effect waves-light btn btn-large btn-block #ff5252 red accent-2" href="${pageContext.request.contextPath}/ListeEmploye">annuler</a>
						</div>
						<div class="col s5 " onclick="javascript:checkOnSubmit()">
							<input type="button" value="ajouter" class="waves-effect waves-light btn btn-large btn-block deep-purple lighten-1">
						</div>
		    		</div>
		    	</form>
		    	<div id="error" class="modal">
			    	<div class="modal-content">
			      		<h4>Erreur</h4>
			      		<p id="messageErreur">Mot de passe incorect</p>
			    	</div>
			   		<div class="modal-footer">
			      		<a href="#!" class=" modal-action modal-close waves-effect waves-purble btn-flat">Ok</a>
			    	</div>
			  	</div>
			</div>		
			
		</main>
		<footer class="side">
			<%@include file="/web/jsp/fragments/scripts.jspf" %>			
		</footer>
	</body>
</html>