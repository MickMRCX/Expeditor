package service.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.IUtilisateurDAL;
import dal.impl.DALFactory;
import dal.impl.UtilisateurDAL;
import model.Utilisateur;

/**
 * Servlet implementation class GestionEmploye
 */
@WebServlet("/GestionEmploye")
public class GestionEmploye extends HttpServlet {
	
	private static final String ACTION = "action";
	private static final String ACTION_DELETE = "delete";
	private static final String ACTION_MODIFY = "modify";
	private static final String ACTION_ADD = "add";
	
	private static final String ID = "id";
	private static final String LOGIN = "login";
	private static final String NOM = "nom";
	private static final String MOT_DE_PASSE = "motDePasse";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEmploye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String action = request.getParameter(ACTION);
		IUtilisateurDAL dal = DALFactory.getUtilisateurDAL();
		if (action.equalsIgnoreCase(ACTION_ADD)) {
			
			String nom = request.getParameter(NOM);
			String login = request.getParameter(LOGIN);
			String motDePasse = request.getParameter(MOT_DE_PASSE);
			
			Utilisateur user = new Utilisateur(nom, login, motDePasse);
			
			dal.insert(user);

		}else if(action.equalsIgnoreCase(ACTION_MODIFY)){
			
			int identifiant = Integer.valueOf(request.getParameter(ID));
			String nom = request.getParameter(NOM);
			String login = request.getParameter(LOGIN);
			String motDePasse = request.getParameter(MOT_DE_PASSE);			
			
			Utilisateur user = new Utilisateur(identifiant, nom, login, motDePasse);
			
			dal.upadte(user);
			
		}else if(action.equalsIgnoreCase(ACTION_DELETE)){
			
			int identifiant = Integer.valueOf(request.getParameter(ID));
			
			Utilisateur user = new Utilisateur(identifiant, null, null, null);
			
			dal.delete(user.getIdentifiant());
			
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Employe");
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
