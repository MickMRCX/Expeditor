<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="dto.Statistiques" %>
<%@ page import="dto.LigneStatistiques" %>
	<%@include file="/web/jsp/fragments/head.jspf" %>
	<body onload="">
		<header>
			<%@include file="/web/jsp/fragments/sideNav.jspf" %>
			<%@include file="/web/jsp/fragments/topMenuBar.jspf" %>			  
		
    	</header>
		<main class="side">
			<div class="scroll-page">
				<%
	        	if(request.getAttribute("statistiques") != null){

					Statistiques statistiques = (Statistiques) request.getAttribute("statistiques");
					for(LigneStatistiques ligne : statistiques.getLignes())
					{
				%>
				<br >
				<div class="row">
					<div class="col offset-s1 s5">
						<h4><%=ligne.getNomEmploye()%></h4>
					</div>
					<div class="col s5 right-align">
						<h4><%=ligne.getNbCommandes()%>/<%=statistiques.getNbCommandesTotal()%></h4>
					</div>
					<div class="col offset-s1 s10">
					  <div class="progress">
					      <div class="determinate" style="width: <%=ligne.getNbCommandes()/statistiques.getNbCommandesTotal()*100%>%"></div>
					  </div>
					</div>
				</div>
				<%}
				}%>
			</div>
			
		</main>
		<footer class="side">
			<%@include file="/web/jsp/fragments/scripts.jspf" %>			
		</footer>
	</body>
</html>