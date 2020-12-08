package fr.eseo.twic.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import fr.eseo.twic.beans.Ville;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

		ArrayList<Ville> villes = null;
		
		try {
			JsonParser jsonParser = new JsonParser();
			JsonArray jsonArray = (JsonArray) jsonParser.parse(readURL("http://localhost:8181/ville"));
			villes = this.parseToVille(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("villes", villes);

		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire/villes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire/villes.jsp").forward(request, response);
	}


	public String readURL(String url) throws IOException {
		  try(InputStream is = new URL(url).openConnection().getInputStream()) {			
		    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
		 
		    StringBuilder builder = new StringBuilder();
		    for(String line = reader.readLine(); line != null; line = reader.readLine()) {
		      builder.append(line + "\n");
		    }
		    return builder.toString();
		  }
		}
	
	private ArrayList<Ville> parseToVille(JsonArray js) {
		final Gson gson = new GsonBuilder().create();
		ArrayList<Ville> villes = new ArrayList<>();

		// Itération autour du tableau de données
		for (JsonElement element : js) {
			villes.add(gson.fromJson(element, Ville.class));
		}
		return villes;
	}
	
	
}
