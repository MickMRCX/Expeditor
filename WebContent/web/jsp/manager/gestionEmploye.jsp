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
			<table class="striped table-commande table-med-screen">
		        <thead>
		          <tr>
		              <th data-field="nomEmploye">Nom</th>
		              <th data-field="login">Login</th>
		              <th data-field="action" class="center-align">Action</th>
		          </tr>
		        </thead>
		        <tbody>
		        	<%
		        		List<Utilisateur> employes = (List<Utilisateur>)request.getAttribute("employes");
		        		for(Utilisateur employe : employes)
		        		{
		        	%>
					<tr>
						<td><%=employe.getNom()%></td>
						<td><%=employe.getLogin()%></td>
						<td>
							<div class="row">
								<div class="col s3 offset-s3 center-align">
									<a href="${pageContext.request.contextPath}/GestionEmploye?action=modify&id=<%=employe.getIdentifiant()%>"><i class="material-icons fa fa-pencil fa-lg"></i></a>
								</div>
								<div class="col s3 center-align">
									<a href="${pageContext.request.contextPath}/GestionEmploye?action=delete&id=<%=employe.getIdentifiant()%>"><i class="material-icons fa fa-trash  fa-lg"></i></a>
								</div>
							</div>
						</td>
					</tr>
					<%} %>			
				</tbody>
		    </table>
		    <div class="row">
				<br >
				<div class="col s10 offset-s1">
					<a class="waves-effect waves-light btn btn-large btn-block deep-purple lighten-1" href="${pageContext.request.contextPath}/GestionEmploye?action=add"><b >ajouter</b></a>
				</div>
			</div>		
			
		</main>
		<footer class="side">
			<%@include file="/web/jsp/fragments/scripts.jspf" %>			
		</footer>
	</body>
</html>