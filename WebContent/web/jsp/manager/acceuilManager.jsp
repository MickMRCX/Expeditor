<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>-->
	<%@include file="/web/jsp/fragments/head.jspf" %>
	<body>
		<header>
			<%@include file="/web/jsp/fragments/topMenuBar.jspf" %>
			<nav>
			  <ul class="right hide-on-med-and-down">
			    <li><a href="#!">First Sidebar Link</a></li>
			    <li><a href="#!">Second Sidebar Link</a></li>
			  </ul>
			  <ul id="slide-out" class="side-nav">
			    <li><a href="#!">First Sidebar Link</a></li>
			    <li><a href="#!">Second Sidebar Link</a></li>
			  </ul>
			  <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
			</nav>
		</header>
		<main>
			
		</main>
		<footer>
			<%@include file="/web/jsp/fragments/scripts.jspf" %>
		</footer>
	</body>
</html>