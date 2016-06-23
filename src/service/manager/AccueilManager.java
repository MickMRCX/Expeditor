package service.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.LigneCommandeManager;

/**
 * Servlet implementation class AccueilManager
 */
@WebServlet("/AccueilManager")
public class AccueilManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ACCUEIL_MANAGER = "/web/jsp/manager/accueilManager.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilManager() {
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
		List<LigneCommandeManager> commandes = new ArrayList<LigneCommandeManager>();//DAL
		request.setAttribute("commandes", commandes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(ACCUEIL_MANAGER);
		requestDispatcher.forward(request, response);
	}
}
