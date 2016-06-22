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
import model.Article;

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
	private static final String POIDS = "poids";
	private static final String LIBELLE = "libelle";
       
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
		
		IArticleDAL dal = new IArticleDAL() {
			
			@Override
			public Article upadte(Article obj) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Article insert(Article obj) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Article getOneByID(int id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Article> getAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void delete(Article obj) {
				// TODO Auto-generated method stub
				
			}
		};
		
		String action = request.getParameter(ACTION);		
		
		if (action.equalsIgnoreCase(ACTION_ADD)) {
			
			int libelle = Integer.valueOf(request.getParameter(LIBELLE));
			int poids = Integer.valueOf(request.getParameter(POIDS));
			
			Article article = new Article(libelle, poids);
			
			dal.insert(article);

		}else if(action.equalsIgnoreCase(ACTION_MODIFY)){
			
			
			int identifiant = Integer.valueOf(request.getParameter(ID));
			int libelle = Integer.valueOf(request.getParameter(LIBELLE));
			int poids = Integer.valueOf(request.getParameter(POIDS));
			
			Article article = new Article(identifiant, libelle, poids);
			
			dal.upadte(article);
			
		}else if(action.equalsIgnoreCase(ACTION_DELETE)){
			
			int identifiant = Integer.valueOf(request.getParameter(ID));
			
			Article article = new Article(identifiant, 0, 0);
			
			dal.delete(article);
			
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
