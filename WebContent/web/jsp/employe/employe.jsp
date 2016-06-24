<%@page import="model.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="dto.LigneCommandeArticle" %>
<%@ page import="model.Commande" %>

	<%@include file="/web/jsp/fragments/head.jspf" %>
	<body>
		<header>
			<%@include file="/web/jsp/fragments/topMenuBar.jspf" %>
		</header>
		<main>
			<div class="commande-client col s12">
				<div class="row">
					<div class="col s10 offset-s1">
						<%						
							if(request.getAttribute("commande") != null && request.getAttribute("articles") != null){
								Commande c = (Commande) request.getAttribute("commande");
								List<Article> articles = (List<Article>) request.getAttribute("articles");
							%>
							<h4><%=c.getIdentifiant()%> - <%=c.getDate_Commande() %></h4>
							<h5><%=c.getNom_Client()%></h5>
							<h5><%=c.getAdresse()%></h5>
							<%for(LigneCommandeArticle lca : c.getArticle_commande()){%>
							<p><%=LigneCommandeArticle.getArticleFromId(lca.getArticle(),articles).getLibelle()%> - <%=lca.getQuantiteCommande()%>
							<%}
							}%>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s10 offset-s1">
					<br >
					<table class="striped table-commande">
				        <thead>
				          <tr>
				              <th data-field="article">Article</th>
				              <th data-field="Qtt">Qtt</th>
				              <th data-field="poidU">Poid U</th>
				              <th data-field="poidT">Poid Total</th>
				           	  <th data-field="act" class="center-align">Action</th>
				          </tr>
				        </thead>
				        <tbody>
				        <%
				        	if(request.getAttribute("commande") != null && request.getAttribute("articles") != null){
				        		Commande c = (Commande) request.getAttribute("commande");
								List<Article> articles = (List<Article>) request.getAttribute("articles");
								for(LigneCommandeArticle lca : c.getArticle_commande()){
									Article a = LigneCommandeArticle.getArticleFromId(lca.getArticle(), articles);
									%>
									<tr>
										<td><%=a.getLibelle()%></td>
										<td id="qttTraite_<%=a.getIdentifiant()%>" ><%=lca.getQuantiteTraitee() %></td>
										<td id="poidArticle_<%=a.getIdentifiant()%>"><%=a.getPoids() %></td>
										<td id="poidTotal_<%=a.getIdentifiant()%>"><%=a.getPoids() * lca.getQuantiteTraitee()%></td>
										<td>
											<div class="col s3 offset-s3 center-align">
												<a onclick="substractArticleAjax(<%=a.getIdentifiant()%>)"><i class="material-icons fa fa-minus-square-o fa-lg"></i></a>
											</div>
											<div class="col s3 center-align">
												<a onclick="addArticleAjax(<%=a.getIdentifiant()%>)"><i class="material-icons fa fa-plus-square-o  fa-lg"></i></a>
											</div>
										</td>
									</tr>
								<%}
				        	}
				        %>
				        </tbody>
				        <tfoot>
				        	<tr>
				        		<td>Total</td>
				        		<td></td>
				        		<td></td>
				        		<td id="poidTotalAll" >16100</td>
				        		<td></td>
				        	</tr>
				        </tfoot>
				    </table>	
				</div>
			</div>
			<div class="row">
				<br >
				<div class="col s10 offset-s1">
					<a class="waves-effect waves-light btn btn-large btn-block deep-purple lighten-1"><i class="fa fa-print col s4 "></i><b class="col s4">valider</b> <i class="fa fa-check col s4"></i></a>
				</div>
			</div>
		</main>
		<footer>
			<%@include file="/web/jsp/fragments/scripts.jspf" %>
		</footer>
	</body>
</html>