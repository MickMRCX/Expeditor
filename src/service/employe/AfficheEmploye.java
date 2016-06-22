package service.employe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.IUtilisateurDAL;
import model.Commande;
import model.Etats;
import model.Utilisateur;

/**
 * Servlet implementation class AfficheEmploye
 */
@WebServlet("/AfficheEmploye")
public class AfficheEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheEmploye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IUtilisateurDAL userDAL = new IUtilisateurDAL() {
			
			@Override
			public void upadte(Utilisateur obj) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insert(Utilisateur obj) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Utilisateur getOneByID(int id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Utilisateur> getAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void delete(Utilisateur obj) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Utilisateur getOneByLogin(String login) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		String idUserString = request.getParameter("email");
		int idUser = Integer.valueOf(idUserString);
        Utilisateur user = userDAL.getOneByID(idUser);
        Commande commande = new Commande(0, new Date(), "Joseph", "120 rue Pascal",0);
        
        RequestDispatcher rs = request.getRequestDispatcher("Welcome");
        rs.forward(request, response);
        
        out.println("Hello World !!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
