<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fr.eseo.twic.beans.Ville"%>

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
				<h1 class="font-weight-light">Calcul la distance entre les
					villes</h1>
				<p class="lead">Merci d'utiliser notre service de calcul,
					veuillez choisir les villes :</p>
				<div style="height: 400px">
					<br> <br>
					<div class="row vertical-offset-100">
						<div class="col-sm-5 mx-auto">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Villes choisies :</h3>
									<br>
								</div>
								<div class="panel-body">
									<FORM method="post" action="CalculerDistanceServlet">
										<fieldset>
											<div class="form-group">

												<SELECT name="ville1" size="1">
													<%
														ArrayList<Ville> liste1 = (ArrayList) session.getAttribute("villes");
													for (Ville ville : liste1) {
													%>
													<OPTION>
														<%=ville.getNomCommune()%>
														<%
															}
														%>
													
												</SELECT> <SELECT name="ville2" size="1">
													<%
														ArrayList<Ville> liste2 = (ArrayList) session.getAttribute("villes");
													for (Ville ville : liste2) {
													%>
													<OPTION>
														<%=ville.getNomCommune()%>
														<%
															}
														%>
													
												</SELECT> <br> <br> <input
													class="btn btn-lg btn-primary btn-block" type="submit"
													value="Calcul de la distance" name="action">
											</div>
										</fieldset>
										<input class="btn btn-lg btn-primary btn-block" type="submit"
											value="Voir la météo" name="action">
									</FORM>
									<br>
									<a href="afficheVille"> Afficher les villes </a><br>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>