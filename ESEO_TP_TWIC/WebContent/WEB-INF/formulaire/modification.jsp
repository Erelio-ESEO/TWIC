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
	<br>
	<div class="container">
		<div class="card border-0 shadow my-5">
			<div class="card-body p-5">
				<h1 class="font-weight-light">Modification de la ville</h1>
				<p class="lead">Veuillez renseigner les informations :</p>
				<div style="height: 500px">
					<br> <br>
					<div class="row vertical-offset-100">
						<div class="col-sm-5 mx-auto">
							<div class="panel panel-default">
								<div class="panel-heading">
								</div>
								<div class="panel-body">
									
									<form accept-charset="UTF-8" role="form" method="post"
										action="envoiModification">
										<fieldset>
											<div class="form-group">
												<br> <br> <SELECT name="codeCommune" size="1">
													<%
														ArrayList<Ville> liste = (ArrayList) session.getAttribute("villes");
													for (Ville ville : liste) {
													%>
													<OPTION>
														<%=ville.getCodeCommune()%>
														<%
															}
														%>
													
												</SELECT> <br> <br>
												<div class="form-group">
													<input class="form-control" placeholder="nomCommune"
														required name="nomCommune" type="text" value="">
												</div>
												<div class="form-group">
													<input class="form-control" placeholder="codePostal"
														required name="codePostal" type="text" value="">
												</div>
												<div class="form-group">
													<input class="form-control"
														placeholder="libelleAcheminement" required
														name="libelleAcheminement" type="text" value="">
												</div>
												<div class="form-group">
													<input class="form-control" placeholder="ligne" type="text"
														value="">
												</div>
												<div class="form-group">
													<input class="form-control" placeholder="longitude"
														required name="longitude" type="text" value="">
												</div>
												<div class="form-group">
													<input class="form-control" placeholder="latitude" required
														name="latitude" type="text" value="">
												</div>
												<input class="btn btn-lg btn-primary btn-block"
													type="submit" value="envoyer">
											</div>
										</fieldset>
									</form>
								</div>
							</div>
						</div>
					</div>
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