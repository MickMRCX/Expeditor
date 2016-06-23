<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/web/jsp/fragments/head.jspf" %>
	<body onload="">
		<header>
			<%@include file="/web/jsp/fragments/sideNav.jspf" %>
			<%@include file="/web/jsp/fragments/topMenuBar.jspf" %>			  
    	</header>
		<main class="side">
		    <div class="row vertical-spacing-20">
		    	<form class="col s12" action="#" method="post">
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
					          <input id="nomArticle" name="nomArticle" type="text" class="validate">
					          <label for="nomArticle">Nom de l'article</label>
				        </div>
		    		</div>
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
					          <input id="poidArticle" name="poidArticle" type="text" class="validate">
					          <label for="poidArticle">Poid de l'article</label>
				        </div>
		    		</div>
		    		<div class="row vertical-spacing">
		    			
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