<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="model.Article" %>
	<%@include file="/web/jsp/fragments/head.jspf" %>
	<body onload="">
		<header>
			<%@include file="/web/jsp/fragments/sideNav.jspf" %>
			<%@include file="/web/jsp/fragments/topMenuBar.jspf" %>			  
    	</header>
		<main class="side">
		    <div class="row vertical-spacing-20">
		    	<% 
			    	Article article = null;
			    	if(request.getAttribute("article")!= null){ 
			    		article = (Article) request.getAttribute("article");
			    	}
		    	%>
		    	<form class="col s12" action="${pageContext.request.contextPath}/GestionArticle" method="post" id="formArticle">
		    		<%if( article != null){%>
		    			<input type="hidden" value="<%=article.getIdentifiant()%>" name="id">
		    			<input type="hidden" value="modify" name="action">
		    		<%}else{%>
		    			<input type="hidden" value="add" name="action">
		    		<%} %>
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
		    				  <%if( article != null){%>
		    						<input id="nomArticle" name="nomArticle" type="text" value="<%=article.getLibelle()%>" class="validate">
		    				  <%}else{ %>
		    				  		<input id="nomArticle" name="nomArticle" type="text" class="validate">
		    				  <%} %>
					          <label for="nomArticle">Nom de l'article</label>
				        </div>
		    		</div>
		    		<div class="row">
		    			<div class="input-field col s10 offset-s1">
		    				  <%if( article != null){%>
		    						<input id="poidArticle" name="poidArticle" type="text" value="<%=article.getPoids()%>" class="validate">
		    				  <%}else{ %>
		    				 		<input id="poidArticle" name="poidArticle" type="text" class="validate">
		    				  <%} %>
					          <label for="poidArticle">Poid de l'article</label>
				        </div>
		    		</div>
		    		<div id="error" class="modal">
				    	<div class="modal-content">
				      		<h4>Erreur</h4>
				      		<p id="messageErreur">Mot de passe incorect</p>
				    	</div>
				   		<div class="modal-footer">
				      		<a href="#!" class=" modal-action modal-close waves-effect waves-purble btn-flat">Ok</a>
				    	</div>
				  	</div>
		    		<div class="row vertical-spacing">
		    			
						<div class="col s5 offset-s1">
							<a class="waves-effect waves-light btn btn-large btn-block #ff5252 red accent-2" href="${pageContext.request.contextPath}/ListeArticles">annuler</a>
						</div>
						<div class="col s5 " onclick="javascript:checkOnArticle()">
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