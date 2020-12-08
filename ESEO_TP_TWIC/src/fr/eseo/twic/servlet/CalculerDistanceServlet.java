package fr.eseo.twic.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import fr.eseo.twic.beans.Ville;

/**
 * Servlet implementation class CalculerDistanceServlet
 */
@WebServlet("/CalculerDistanceServlet")
public class CalculerDistanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculerDistanceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ArrayList<Ville> villes = (ArrayList<Ville>) session.getAttribute("villes");
		String ville1 = request.getParameter("ville1");
		String ville2 = request.getParameter("ville2");
		session.setAttribute("ville1", ville1);
		session.setAttribute("ville2", ville2);

		String latitude1 = null;
		String longitude1 = null;
		String latitude2 = null;
		String longitude2 = null;

		for (Ville ville : villes) {
			if (ville.getNomCommune().equals(ville1)) {
				latitude1 = ville.getLatitude();
				longitude1 = ville.getLongitude();
			}
			if (ville.getNomCommune().equals(ville2)) {
				latitude2 = ville.getLatitude();
				longitude2 = ville.getLongitude();
			}
		}

		if (request.getParameter("action").equals("Calcul de la distance")) {

			DecimalFormat df = new DecimalFormat("###.##");
			double distance = this.calculDistance(latitude1, longitude1, latitude2, longitude2);
			session.setAttribute("distance", df.format(distance));
			this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire/distance.jsp").forward(request, response);
		} else {
			HttpResponse<JsonNode> reponse1;
			HttpResponse<JsonNode> reponse2;
			String url1 = "http://api.openweathermap.org/data/2.5/weather?APPID=2129170164288096a566a7b4580ed806&lat="
					+ latitude1 + "&lon=" + longitude1 + "";
			String url2 = "http://api.openweathermap.org/data/2.5/weather?APPID=2129170164288096a566a7b4580ed806&lat="
					+ latitude2 + "&lon=" + longitude2 + "";
			try {
				DecimalFormat df = new DecimalFormat("###.##");
				reponse1 = Unirest.get(url1).asJson();
				reponse2 = Unirest.get(url2).asJson();

				JsonElement jArray1 = JsonParser.parseString(reponse1.getBody().toString());
				JsonElement jArray2 = JsonParser.parseString(reponse2.getBody().toString());
				JsonObject rootObject1 = jArray1.getAsJsonObject();
				JsonObject rootObject2 = jArray2.getAsJsonObject();
				String tempFVille1 = rootObject1.getAsJsonObject("main").get("temp").toString();
				String tempFVille2 = rootObject2.getAsJsonObject("main").get("temp").toString();
				double tempCVille1 = this.fahrenheitToCelcius(Double.parseDouble(tempFVille1));
				double tempCVille2 = this.fahrenheitToCelcius(Double.parseDouble(tempFVille2));
				session.setAttribute("tempsVille1", df.format(tempCVille1));
				session.setAttribute("tempsVille2", df.format(tempCVille2));

			} catch (UnirestException e) {
				e.printStackTrace();
			}
			session.setAttribute("villes", villes);

			this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire/voirMeteo.jsp").forward(request, response);
		}
	}

	public double calculDistance(String latitude1, String longitude1, String latitude2, String longitude2) {
		double b2 = Double.parseDouble(latitude1);
		double c2 = Double.parseDouble(longitude1);

		double b3 = Double.parseDouble(latitude2);
		double c3 = Double.parseDouble(longitude2);

		double distance = Math.acos(Math.sin(Math.toRadians(b2)) * Math.sin(Math.toRadians(b3))
				+ Math.cos(Math.toRadians(b2)) * Math.cos(Math.toRadians(b3)) * Math.cos(Math.toRadians(c2 - c3))) * 6371;
		return distance;
	}
	
	public double fahrenheitToCelcius(double temp) {
		return temp - 273.15;
	}

}
