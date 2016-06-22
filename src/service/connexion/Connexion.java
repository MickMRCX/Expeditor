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

import dal.ICommandeDAL;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UtilisateurDAL UtilisateurDAL = new UtilisateurDAL();
		Utilisateur user = UtilisateurDAL.getOneByLogin(request.getUserPrincipal().getName());
	    this.getServletConfig().getServletContext().setAttribute("user", user);
	    ICommandeDAL commandeDAL = new ICommandeDAL() {
			
			@Override
			public Commande upadte(Commande obj) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Commande insert(Commande obj) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Commande getOneByID(int id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Commande> getAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void delete(Commande obj) {
				// TODO Auto-generated method stub
				
			}
		};
	    
        Commande commande = commandeDAL.getOneByID(0);

        RequestDispatcher requestDispatcher;
	    if (commande != null) {
	    	this.getServletConfig().getServletContext().setAttribute("commande", commande);
	    	requestDispatcher = request.getRequestDispatcher("Employe");
		}else{
			requestDispatcher = request.getRequestDispatcher("Manager");	        
		}
	    requestDispatcher.forward(request, response);
	}

}
