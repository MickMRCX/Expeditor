<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>-->
	<%@include file="/web/jsp/fragments/head.jspf" %>
	<body onload="">
		<header>
			<%@include file="/web/jsp/fragments/sideNav.jspf" %>
			<%@include file="/web/jsp/fragments/topMenuBar.jspf" %>			  
		
    	</header>
		<main class="side">
			<div class="row">
				<div class="col s6">
					Michel
				</div>
				<div class="col s6">
					5/12
				</div>
				<div class="col s12">
				  <div class="progress">
				      <div class="determinate" style="width: 70%"></div>
				  </div>
				</div>
			</div>
			
		</main>
		<footer class="side">
			<%@include file="/web/jsp/fragments/scripts.jspf" %>			
		</footer>
	</body>
</html>