package service.employe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionAjoutAjax
 */
@WebServlet("/GestionAjoutAjax")
public class GestionAjoutAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String IDENTIFIANT_ARTICLE = "idArticle";
	private static String IDENTIFIANT_COMMANDE = "idCommande";
	private static String ACTION = "action";
	private static String METHOD_ADD = "add";
	private static String METHOD_SUBSTRACT = "substract";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionAjoutAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idArticle = Integer.getInteger(request.getParameter(IDENTIFIANT_ARTICLE));
		int idCommande = Integer.getInteger(request.getParameter(IDENTIFIANT_COMMANDE));
		String action = request.getParameter(ACTION);
		if(action == METHOD_ADD){
			
		}
		else if(action==METHOD_SUBSTRACT){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
