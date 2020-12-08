<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fr.eseo.twic.beans.Ville"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: darkgrey;">
	<div class="container">
		<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="afficheVille?page=
				<%Integer pages = (Integer) request.getAttribute("numPage");
				if (pages <= 1) {
					pages = 2;
				}%>
				<%=pages - 1%>">Previous</a></li>
			<li class="page-item"><a class="page-link"
				href="afficheVille?page=1">1</a></li>
			<li class="page-item"><a class="page-link"
				href="afficheVille?page=2">2</a></li>
			<li class="page-item"><a class="page-link"
				href="afficheVille?page=3">3</a></li>
			<li class="page-item"><a class="page-link" href="afficheVille?page=
				<%Integer pagesS = (Integer) request.getAttribute("numPage");%>
				<%=pagesS + 1%>">Next</a></li>
		</ul>
	</nav>
		<div class="card border-0 shadow my-5">
			<div class="card-body p-5">
				<h1 class="font-weight-light">Liste des villes :</h1>
				<br>
				<div style="height: 2500px">
					<FORM method="post" action="modification">
						<%
							ArrayList<Ville> liste2 = (ArrayList) request.getAttribute("villesPage");
						for (Ville ville : liste2) {
						%>
						<%=ville.getNomCommune()%>
						<a href="modification?ville=<%=ville.getNomCommune()%>">modifier</a>
						<a href="suppression?ville=<%=ville.getNomCommune()%>">supprimer</a><br>
						<br>
						<%
							}
						%>

					</FORM>
				</div>
			</div>
		</div>
	</div>
</body>



<!-- Bootstrap core JavaScript -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>


</html>