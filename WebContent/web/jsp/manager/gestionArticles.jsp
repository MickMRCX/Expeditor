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
			<table class="striped table-commande table-med-screen">
		        <thead>
		          <tr>
		              <th data-field="nomEmploye">Nom</th>
		              <th data-field="login">Poid</th>
		              <th data-field="action" class="center-align">Action</th>
		          </tr>
		        </thead>
		        <tbody>
		        	<%
		        	if(request.getAttribute("articles") != null){
		        		List<Article> articles = (List<Article>)request.getAttribute("articles");
		        		for(Article article : articles)
		        		{
		        	%>
					<tr>
						<td><%=article.getLibelle() %></td>
						<td><%=article.getPoids() %></td>
						<td>
							<div class="row">
								<div class="col s3 offset-s3 center-align">
									<a href="${pageContext.request.contextPath}/GestionArticle?action=modify&id=<%=article.getIdentifiant()%>" ><i class="material-icons fa fa-pencil fa-lg"></i></a>
								</div>
								<div class="col s3 center-align">
									<a href="${pageContext.request.contextPath}/GestionArticle?action=delete&id=<%=article.getIdentifiant()%>" ><i class="material-icons fa fa-trash  fa-lg"></i></a>
								</div>
							</div>
						</td>
					</tr>
					<%} 
					}%>	
				</tbody>
		    </table>
		    <div class="row">
				<br >
				<div class="col s10 offset-s1">
					<a class="waves-effect waves-light btn btn-large btn-block deep-purple lighten-1" href="${pageContext.request.contextPath}/GestionArticle"><b class="">ajouter</b></a>
				</div>
			</div>		
			
		</main>
		<footer class="side">
			<%@include file="/web/jsp/fragments/scripts.jspf" %>			
		</footer>
	</body>
</html>