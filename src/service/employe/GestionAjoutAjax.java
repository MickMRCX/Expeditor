package service.employe;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.impl.CommandeArticleDAL;

/**
 * Servlet implementation class GestionAjoutAjax
 */
@WebServlet("/GestionAjoutAjax")
public class GestionAjoutAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String IDENTIFIANT_ARTICLE = "idArticle";
	private static String IDENTIFIANT_COMMANDE = "idCommande";
	// private static String ACTION = "action";
	// private static String METHOD_ADD = "add";
	// private static String METHOD_SUBSTRACT = "substract";
       
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
		String toto = request.getParameter("idArticle");
		int idArticle = Integer.parseInt(toto);
		String cmd = request.getParameter("idCommande");
		int idCommande = Integer.parseInt(cmd);
		int qte = Integer.parseInt(request.getParameter("qtt"));
		CommandeArticleDAL dal = new CommandeArticleDAL();			
		dal.update(idArticle, idCommande, qte);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	// Based on code from: http://www.coderanch.com/t/383310/java/java/parse-url-query-string-parameter
    private static Map<String, String> makeQueryMap(String query) throws UnsupportedEncodingException {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for( String param : params ) {
            String[] split = param.split("=");
            map.put(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
        }
        return map;
    }

}
