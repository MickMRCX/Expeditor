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

import dal.IUtilisateurDAL;
import dal.impl.DALFactory;
import model.Utilisateur;

/**
 * Servlet implementation class ListeEmploye
 */
@WebServlet("/ListeEmploye")
public class ListeEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeEmploye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUtilisateurDAL userDAl = DALFactory.getUtilisateurDAL();		
		List<Utilisateur> employes = userDAl.getEmployes();
		request.setAttribute("employes", employes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Expeditor/WebContent/web/jsp/manager/gestionEmploye.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
