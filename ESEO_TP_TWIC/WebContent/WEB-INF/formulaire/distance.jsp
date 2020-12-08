<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Calcul de la distance</title>
<meta charset="ISO-8859-1">
<!-- Css-->
<link href="inc/css/index.css" rel="stylesheet">
</head>

<!-- Page Content -->
<body style="background-color: darkgrey;">
	<br>
	<div class="container">
		<div class="card border-0 shadow my-5">
			<div class="card-body p-5">
					<h1 class="font-weight-light">Résultat du calcul</h1>
					<p class="lead">
						La distance entre
						<%=session.getAttribute("ville1")%>
						et
						<%=session.getAttribute("ville2")%>
						est de
						<%=session.getAttribute("distance")%>
						km. <br> Si vous voulez de nouveau <a href=ConnexionServlet>lancer
							un nouveau calcul</a><br>
					</p>

				</div>
			</div>
		</div>
	</div>
</body>
</html> 