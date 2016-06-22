package service.employe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;
import model.Commande;
import model.Utilisateur;

/**
 * Servlet implementation class AccueilEmploye
 */
@WebServlet("/AccueilEmploye")
public class AccueilEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ACCUEIL_EMPLOYE = "/web/jsp/employe/employe.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilEmploye() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processExecute(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processExecute(request, response);
	}

	private void processExecute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		// Commande commande = (Commande)
		// request.getSession().getAttribute("commande");
		// List<Article> articles = new ArrayList<Article>(); // appel DAL
		// request.setAttribute("commande", commande);
		// request.setAttribute("articles", articles);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(ACCUEIL_EMPLOYE);
		requestDispatcher.forward(request, response);
	}

}
