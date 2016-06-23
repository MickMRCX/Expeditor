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
	private static final String LOGIN = "loginEmploye";
	private static final String NOM = "nomEmploye";
	private static final String MOT_DE_PASSE = "mdp";
	
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
		RequestDispatcher requestDispatcher = null;
		if (action.equalsIgnoreCase(ACTION_ADD)) {
				
			requestDispatcher = request.getRequestDispatcher("/web/jsp/manager/ajoutEmploye.jsp");
	
		}else if(action.equalsIgnoreCase(ACTION_MODIFY)){
			Utilisateur user = dal.getOneByID(Integer.valueOf(request.getParameter(ID)));
			request.setAttribute("user", user);
			requestDispatcher = request.getRequestDispatcher("/web/jsp/manager/ajoutEmploye.jsp");
				
		}
		else if(action.equalsIgnoreCase(ACTION_DELETE)){
			
			int identifiant = Integer.valueOf(request.getParameter(ID));
						
			dal.delete(identifiant);
			requestDispatcher = request.getRequestDispatcher("ListeEmploye");
			
		}else{
			requestDispatcher = request.getRequestDispatcher("ListeEmploye");
		}
		
	    requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			dal.update(user);
			
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListeEmploye");
	    requestDispatcher.forward(request, response); 
	}

}
