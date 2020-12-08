package fr.eseo.twic.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.twic.beans.Ville;

/**
 * Servlet implementation class afficheVille
 */
@WebServlet("/afficheVille")
public class afficheVille extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public afficheVille() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String numero = request.getParameter("page");
		int page = numero != null ? Integer.parseInt(numero) : 1;
		ArrayList<Ville> villes = (ArrayList<Ville>) session.getAttribute("villes");
		villes = getNElements(page, 50, villes);
		request.setAttribute("villesPage", villes);
		request.setAttribute("numPage", page);
		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire/afficheVilles.jsp").forward(request, response);
	}

	private ArrayList getNElements(int start, int size, ArrayList list) {
		start--;
		ArrayList myList = new ArrayList();
		for (int i = start; i < start + size; i++) {
			if (i >= list.size()) {
				break;
			}
			myList.add(list.get(i));
		}

		return myList;
	}
}
