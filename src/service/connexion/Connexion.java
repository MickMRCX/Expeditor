package service.connexion;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.naming.factory.DataSourceLinkFactory;

import dal.ICommandeDAL;
import dal.IUtilisateurDAL;
import dal.impl.DALFactory;
import dal.impl.UtilisateurDAL;
import model.Commande;
import model.Etats;
import model.Utilisateur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private final String ROLE_EMPLOYE = "employe";
	private final String ROLE_MANAGER = "manager";
	private final String ACCUEIL_EMPLOYE = "AccueilEmploye";
	private final String ACCUEIL_MANAGER = "AccueilManager";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion() {
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
		IUtilisateurDAL userDAl = DALFactory.getUtilisateurDAL();
		Utilisateur user = userDAl.getOneByLogin(request.getUserPrincipal().getName());
		this.getServletConfig().getServletContext().setAttribute("user", user);
		RequestDispatcher requestDispatcher;
		String destination;

		if (request.isUserInRole(ROLE_MANAGER)) {
			destination = ACCUEIL_MANAGER;
		} else {
			destination = ACCUEIL_EMPLOYE;
		}

		requestDispatcher = request.getRequestDispatcher(destination);
		requestDispatcher.forward(request, response);
	}

}
