<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Expeditor</title>
		<!--Import materialize.css-->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/web/styles/materialize.min.css" media="screen,projection">
		<!--Let browser know website is optimized for mobile-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 	
			
		<!-- Font Awesome -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/web/styles/font-awesome.min.css" media="screen,projection">
		
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/web/styles/style.css" media="screen,projection">
	</head>
	<body>
		<header>
			
			<nav>
				<div class="nav-wrapper  deep-orange lighten-2">
					<a href="" class="brand-logo center ">Expeditor <i class="fa fa-fighter-jet"></i></a>
					<ul class="right">
						<li><a href="#" class=""><i class="material-icons fa fa-sign-out"></i></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<main>
			<div class="commande-client col s12">
				<div class="row">
					<div class="col s10 offset-s1">
						test
						<br >
						<br >
						<br >
						test
						<br >
						<br >
						<br >
						test
						<br >
						<br >
						<br >
						test
						<br >
						<br >
						<br >
						test
						<br >
						<br >
						<br >
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
							<tr>
								<td>Carte Mère</td>
								<td>38</td>
								<td>300</td>
								<td>11400</td>
								<td>
									<div class="col s3 offset-s3 center-align">
										<i class="material-icons fa fa-plus-square-o fa-lg"></i>
									</div>
									<div class="col s3 center-align">
										<i class="material-icons fa fa-minus-square-o  fa-lg"></i>
									</div>
								</td>
							</tr>
							<tr>
								<td>Carte Mère</td>
								<td>38</td>
								<td>300</td>
								<td>11400</td>
								<td class="">
									<div class="col s3 offset-s3 center-align">
										<i class="material-icons fa fa-plus-square-o fa-lg"></i>
									</div>
									<div class="col s3 center-align">
										<i class="material-icons fa fa-minus-square-o  fa-lg"></i>
									</div>
								</td>
							</tr>
							<tr>
								<td>Carte Mère</td>
								<td>38</td>
								<td>300</td>
								<td>11400</td>
								<td class="">
									<div class="col s3 offset-s3 center-align">
										<i class="material-icons fa fa-plus-square-o fa-lg"></i>
									</div>
									<div class="col s3 center-align">
										<i class="material-icons fa fa-minus-square-o  fa-lg"></i>
									</div>
								</td>
							</tr>
							<tr>
								<td>Carte Mère</td>
								<td>38</td>
								<td>300</td>
								<td>11400</td>
								<td class="">
									<div class="col s3 offset-s3 center-align">
										<i class="material-icons fa fa-plus-square-o fa-lg"></i>
									</div>
									<div class="col s3 center-align">
										<i class="material-icons fa fa-minus-square-o  fa-lg"></i>
									</div>
								</td>
							</tr>
							<tr>
								<td>Carte Mère</td>
								<td>38</td>
								<td>300</td>
								<td>11400</td>
								<td class="">
									<div class="col s3 offset-s3 center-align">
										<i class="material-icons fa fa-plus-square-o fa-lg"></i>
									</div>
									<div class="col s3 center-align">
										<i class="material-icons fa fa-minus-square-o  fa-lg"></i>
									</div>
								</td>
							</tr>
							<tr>
								<td>Carte Mère</td>
								<td>38</td>
								<td>300</td>
								<td>11400</td>
								<td class="">
									<div class="col s3 offset-s3 center-align">
										<i class="material-icons fa fa-plus-square-o fa-lg"></i>
									</div>
									<div class="col s3 center-align">
										<i class="material-icons fa fa-minus-square-o  fa-lg"></i>
									</div>
								</td>
							</tr>
							<tr>
								<td>Carte Mère</td>
								<td>38</td>
								<td>300</td>
								<td>11400</td>
								<td class="">
									<div class="col s3 offset-s3 center-align">
										<i class="material-icons fa fa-plus-square-o fa-lg"></i>
									</div>
									<div class="col s3 center-align">
										<i class="material-icons fa fa-minus-square-o  fa-lg"></i>
									</div>
								</td>
							</tr>
				        </tbody>
				        <tfoot>
				        	<tr>
				        		<td>Total</td>
				        		<td></td>
				        		<td></td>
				        		<td>16100</td>
				        		<td></td>
				        	</tr>
				        </tfoot>
				    </table>	
				</div>
			</div>
			<div class="row">
				<div class="col s10 offset-s1">
					<a class="waves-effect waves-light btn btn-large btn-block"><i class="fa fa-print col s4 "></i><b class="col s4">valider</b> <i class="fa fa-check col s4"></i></a>
				</div>
			</div>
		</main>
		<footer>
			<!--Import jQuery before materialize.js-->
			<script type="text/javascript" src="${pageContext.request.contextPath}/web/javascript/jquery-2.1.1.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/web/javascript/materialize.min.js"></script>
			<!-- <script type="text/javascript" src="${pageContext.request.contextPath}/web/javascript/script.js"></script>-->
		</footer>
	</body>
</html>