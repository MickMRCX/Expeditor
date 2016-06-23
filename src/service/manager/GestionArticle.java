package service.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.IArticleDAL;
import dal.IUtilisateurDAL;
import dal.impl.DALFactory;
import model.Article;
import model.Utilisateur;

/**
 * Servlet implementation class GestionArticle
 */
@WebServlet("/GestionArticle")
public class GestionArticle extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private static final String ACTION = "action";
	private static final String ACTION_DELETE = "delete";
	private static final String ACTION_MODIFY = "modify";
	private static final String ACTION_ADD = "add";
	
	private static final String ID = "id";
	private static final String POIDS = "poidArticle";
	private static final String LIBELLE = "nomArticle";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IArticleDAL dal = DALFactory.getArticleDAL();
		
		String action = request.getParameter(ACTION);
		RequestDispatcher requestDispatcher = null;
		if (action.equalsIgnoreCase(ACTION_ADD)) {
				
			requestDispatcher = request.getRequestDispatcher("/web/jsp/manager/ajoutEmploye.jsp");
	
		}else if(action.equalsIgnoreCase(ACTION_MODIFY)){
			Article article = dal.getOneByID(Integer.valueOf(request.getParameter(ID)));
			request.setAttribute("article", article);
			requestDispatcher = request.getRequestDispatcher("/web/jsp/manager/ajoutArticle.jsp");
			
		}else if(action.equalsIgnoreCase(ACTION_DELETE)){
			
			int identifiant = Integer.valueOf(request.getParameter(ID));
						
			dal.delete(identifiant);
			requestDispatcher = request.getRequestDispatcher("ListeArticles");
			
		}	else{
			requestDispatcher = request.getRequestDispatcher("ListeArticles");
		}
	    requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
IArticleDAL dal = DALFactory.getArticleDAL();
		
		String action = request.getParameter(ACTION);		
		
		if (action.equalsIgnoreCase(ACTION_ADD)) {
			
			String libelle = request.getParameter(LIBELLE);
			int poids = Integer.valueOf(request.getParameter(POIDS));
			
			Article article = new Article(libelle, poids);
			
			dal.insert(article);

		}else if(action.equalsIgnoreCase(ACTION_MODIFY)){
			
			
			int identifiant = Integer.valueOf(request.getParameter(ID));
			String libelle = request.getParameter(LIBELLE);
			int poids = Integer.valueOf(request.getParameter(POIDS));
			
			Article article = new Article(identifiant, libelle, poids);
			
			dal.update(article);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListeArticles");
		    requestDispatcher.forward(request, response); 
		}
	}

}
