package service.employe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import dal.IArticleDAL;
import dal.ICommandeDAL;
import dal.impl.DALFactory;
import dto.LigneCommandeArticle;
import model.Article;
import model.Commande;
import model.Utilisateur;
import util.ArticlesCouple;

/**
 * Servlet implementation class ImpressionPDF
 */
@WebServlet("/ImpressionPDF")
public class ImpressionPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImpressionPDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		
		Utilisateur user = (Utilisateur) this.getServletConfig().getServletContext().getAttribute("user");
		int idCommande = Integer.valueOf(request.getParameter("idCommande"));
		ICommandeDAL dalCommande = DALFactory.getCommandeDAL();
		IArticleDAL dalArticle = DALFactory.getArticleDAL();
		Commande commande = dalCommande.getOneByID(idCommande);
		ArticlesCouple coupleArticle = dalArticle.getArticlesByCommande(commande.getIdentifiant());
		java.util.List<Article> articles = coupleArticle.getArticles();
		
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph("Commande" + commande.getIdentifiant()));			
			document.add(new Phrase("Client : " + commande.getNom_Client()));	
			document.add(new Phrase("Adresse : " + commande.getAdresse()));	
			document.add(new Phrase("Commandé le  : " + commande.getDate_Commande()));	
			document.add(new Phrase("Commande traitée par : " + user.getNom()));	
			document.add(new Paragraph("Articles : "));			
			List list = new List(true, 20);
			for (LigneCommandeArticle ligne : commande.getArticle_commande()) {
				Article article = LigneCommandeArticle.getArticleFromId(ligne.getArticle(), articles);
				StringBuilder sbBuilder = new StringBuilder();
				sbBuilder.append("nom : ").append(article.getLibelle()).append(' ');
				sbBuilder.append("Quantité traitée/commandée : ").append(ligne.getQuantiteTraitee()).append('/').append(ligne.getQuantiteCommande()).append(' ');
				sbBuilder.append("poids : ").append(article.getPoids()*ligne.getQuantiteTraitee()).append(' ');
				list.add(new ListItem(sbBuilder.toString()));
			}
			document.add(list);			
			document.close();
		} catch (DocumentException e) {
			throw new IOException(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
